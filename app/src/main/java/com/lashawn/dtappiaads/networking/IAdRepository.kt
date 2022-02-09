package com.lashawn.dtappiaads.networking

import retrofit2.Call

/**
 * Interface used to hide different types of Repositories for this app.
 */
interface IAdRepository {
    suspend fun fetchAds(): Call<String>
}