package com.lashawn.dtappiaads.networking

import com.lashawn.dtappiaads.models.Ads
import retrofit2.Call

/**
 * Repository to be used by viewModels.
 * Please add through Interface IAdRepository.
 */
class AdRepositoryImpl: IAdRepository {
    override suspend fun fetchAds(): Call<Ads> {
        return ApiClient.apiService.fetchAds()
    }
}