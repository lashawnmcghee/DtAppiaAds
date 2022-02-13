package com.lashawn.dtappiaads.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.lashawn.dtappiaads.models.Ad
import com.lashawn.dtappiaads.models.Ads
import com.lashawn.dtappiaads.networking.AdRepositoryImpl
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject
import retrofit2.Call
import retrofit2.Response

class AdListViewModel: ViewModel() {
    private val TAG: String = AdListViewModel::class.java.simpleName
    private val repository: AdRepositoryImpl by inject(AdRepositoryImpl::class.java)
    private val _errorMessage = MutableLiveData<String>()
    private val _ads = MutableLiveData<List<Ad>>()

    //Observables
    val errorMessage: LiveData<String> = _errorMessage
    val ads: LiveData<List<Ad>> = _ads

    @Volatile private var fetching: Boolean = false

    init {
        getAds()
    }

    fun refreshAds() {
        if (!fetching) getAds()
    }

    private fun parseAdsFromXml(responseXml: String) {
        if (responseXml.isEmpty()) return

        viewModelScope.launch {
            val mapper by inject<XmlMapper>(XmlMapper::class.java)
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

            try {
                val adList: Ads = mapper.readValue(responseXml, Ads::class.java)
                _ads.postValue(adList.ads)
                Log.d("DTXml", "Ad xml successfully converted: $adList")
            } catch (ex: Exception) {
                Log.e(TAG, "" + ex.message)
                _errorMessage.postValue(ex.message)
            }
        }
    }

    private fun getAds() {
        fetching = true
        viewModelScope.launch {
            val nodes = repository.fetchAds()

            nodes.enqueue(object: retrofit2.Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    val webResponse = response.body()
                    parseAdsFromXml(webResponse!!)
                    Log.d(TAG, "Web call SUCCESS: $webResponse")
                    fetching = false
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    _errorMessage.postValue(t.message)
                    Log.e(TAG, "Web call FAILURE: " + t.message)
                    fetching = false
                }
            })
        }
    }
}