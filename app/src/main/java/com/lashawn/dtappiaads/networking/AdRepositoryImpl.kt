package com.lashawn.dtappiaads.networking

import retrofit2.Call

/**
 * Repository to be used by viewModels.
 * Please add through Interface IAdRepository.
 */
class AdRepositoryImpl: IAdRepository {
    override suspend fun fetchAds(): Call<String> {
        return ApiClient.apiService.fetchAds()
    }
}