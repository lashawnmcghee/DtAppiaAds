package com.lashawn.dtappiaads.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lashawn.dtappiaads.models.Ad

class SharedViewModel : ViewModel() {
    //TODO: Change to a flow if possible
    private val _ad = MutableLiveData<Ad>()
    val ad: LiveData<Ad> = _ad

    fun provideAd(updatedValue: Ad) {
        _ad.value = updatedValue
    }
}