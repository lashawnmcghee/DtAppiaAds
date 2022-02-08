package com.lashawn.dtappiaads.networking

import retrofit2.Call

class AdRepositoryImpl: IAdRepository {
    override suspend fun fetchAds(): Call<String> {
        return ApiClient.apiService.fetchAds()
    }
}