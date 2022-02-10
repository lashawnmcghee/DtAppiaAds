package com.lashawn.dtappiaads.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lashawn.dtappiaads.models.Ad

/**
 * This view model is owned by our one and only Activity
 * but may be shared to multiple children through use of
 * Koin's sharedViewModel(): import org.koin.androidx.viewmodel.ext.android.sharedViewModel
 * private val sharedViewModel: SharedViewModel by sharedViewModel()
 */
class SharedViewModel : ViewModel() {
    private val emptyAd = Ad()

    //TODO: Change to a flow if possible
    private val _ad = MutableLiveData<Ad>()
    val ad: LiveData<Ad> = _ad

    fun provideAd(updatedValue: Ad) {
        _ad.postValue(updatedValue)
    }

    fun clearAd() {
        _ad.postValue(emptyAd)
    }
}