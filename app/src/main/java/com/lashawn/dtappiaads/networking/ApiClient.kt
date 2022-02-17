package com.lashawn.dtappiaads.networking

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.lashawn.dtappiaads.common.Constants.BASE_URL
import com.lashawn.dtappiaads.common.Constants.QUERY
import com.lashawn.dtappiaads.models.Ads
import org.koin.java.KoinJavaComponent
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.GET

/**
 * Simple client object which creates and exposes a Retrofit
 * API service for use by repositories.
 */
object ApiClient {
    //TODO: Add Injection for service
    private val retrofit: Retrofit by lazy {
        val mapper by KoinJavaComponent.inject<XmlMapper>(XmlMapper::class.java)
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create(mapper))
            .build()
    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

interface ApiService {
    @GET(QUERY)
    fun fetchAds(): Call<Ads>
}