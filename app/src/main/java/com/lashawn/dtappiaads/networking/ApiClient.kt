package com.lashawn.dtappiaads.networking

import com.lashawn.dtappiaads.common.Constants.BASE_URL
import com.lashawn.dtappiaads.common.Constants.QUERY
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

/**
 * Simple client object which creates and exposes a Retrofit
 * API service for use by repositories.
 */
object ApiClient {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

interface ApiService {
    @GET(QUERY)
    fun fetchAds(): Call<String>
}