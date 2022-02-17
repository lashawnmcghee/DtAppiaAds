package com.lashawn.dtappiaads.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lashawn.dtappiaads.models.Ad
import com.lashawn.dtappiaads.models.Ads
import com.lashawn.dtappiaads.models.AdsRequest
import com.lashawn.dtappiaads.networking.AdRepositoryImpl
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject
import retrofit2.Call
import retrofit2.Response

class AdListViewModel: ViewModel() {
    private val TAG: String = AdListViewModel::class.java.simpleName
    private val repository: AdRepositoryImpl by inject(AdRepositoryImpl::class.java)
    private val _adsRequest: AdsRequest by inject(AdsRequest::class.java)

    //Observables
    val errorMessage: LiveData<String> = _adsRequest.error
    val ads: LiveData<List<Ad>> = _adsRequest.ads

    init {
        getAds()
    }

    fun refreshAds() {
        getAds()
    }

    private fun getAds() {
        viewModelScope.launch {
            repository.fetchAds(_adsRequest)
        }
    }
}