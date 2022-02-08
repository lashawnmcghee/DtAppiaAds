package com.lashawn.dtappiaads.networking

import retrofit2.Call

interface IAdRepository {
    suspend fun fetchAds(): Call<String>
}