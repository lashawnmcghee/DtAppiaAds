package com.lashawn.dtappiaads.models

import androidx.lifecycle.MutableLiveData

data class AdsRequest(
    val ads: MutableLiveData<List<Ad>>,
    val error: MutableLiveData<String>
)
