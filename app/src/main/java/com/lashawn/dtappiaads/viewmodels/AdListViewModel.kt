package com.lashawn.dtappiaads.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.lashawn.dtappiaads.common.Constants.closetag
import com.lashawn.dtappiaads.common.Constants.endtag
import com.lashawn.dtappiaads.common.Constants.opentag
import com.lashawn.dtappiaads.common.Constants.starttag
import com.lashawn.dtappiaads.models.Ad
import com.lashawn.dtappiaads.networking.AdRepositoryImpl
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject
import retrofit2.Call
import retrofit2.Response
import java.util.*


class AdListViewModel: ViewModel() {

    private val repository: AdRepositoryImpl by inject(AdRepositoryImpl::class.java)
    private val _ads = MutableLiveData<List<Ad>>()
    val ads: LiveData<List<Ad>> = _ads

    @Volatile var fetching: Boolean = false

    init {
        getAds()
    }

    fun refreshAds() {
        if (!fetching) getAds()
    }

    private fun provideAds(value: List<Ad>) {
        viewModelScope.launch {
            _ads.value = value
        }
    }

    private fun getAds() {
        fetching = true
        viewModelScope.launch {

            val nodes = repository.fetchAds()

            nodes.enqueue(object: retrofit2.Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    var trimmed = response.body()
                    if (trimmed == null || trimmed.isEmpty()) return

                    Log.d("DTResponse", "" + trimmed)

                    val mapper by inject<XmlMapper>(XmlMapper::class.java)
                    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

                    val startIdx = trimmed.indexOf(starttag)
                    val endIdx = trimmed.lastIndexOf(endtag) + endtag.length
                    if (startIdx != -1 ) {
                        trimmed = opentag + trimmed.substring(startIdx, endIdx) + closetag
                    }

                    val adList: Array<Ad> = mapper.readValue(trimmed, Array<Ad>::class.java)

                    Log.d("DTXml", "Ad xml successfully converted: $adList")

                    provideAds(adList.asList())

                    fetching = false
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.e("DTFailure", "" + t.message)
                    fetching = false
                }
            })
        }
    }
}