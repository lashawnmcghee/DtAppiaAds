package com.lashawn.dtappiaads.networking

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lashawn.dtappiaads.models.Ad
import com.lashawn.dtappiaads.models.Ads
import com.lashawn.dtappiaads.models.AdsRequest
import retrofit2.Call
import retrofit2.Response

/**
 * Repository to be used by viewModels.
 * Please add through Interface IAdRepository.
 */
class AdRepositoryImpl: IAdRepository {
    private val TAG = AdRepositoryImpl::class.java.simpleName
    @Volatile private var fetching: Boolean = false

    override fun fetchAds(adsRequest: AdsRequest) {
        if(!fetching) {
            fetching = true
            ApiClient.apiService.fetchAds().enqueue(object : retrofit2.Callback<Ads> {
                override fun onResponse(call: Call<Ads>, response: Response<Ads>) {
                    adsRequest.ads.postValue(response.body()!!.ads)
                    Log.d(TAG, "Web call SUCCESS: ${adsRequest.ads}")
                    fetching = false
                }

                override fun onFailure(call: Call<Ads>, t: Throwable) {
                    adsRequest.error.postValue(t.message)
                    Log.e(TAG, "Web call FAILURE: " + t.message)
                    fetching = false
                }
            })
        }
    }
}