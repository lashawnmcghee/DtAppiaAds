package com.lashawn.dtappiaads.networking

import com.lashawn.dtappiaads.models.AdsRequest

/**
 * Interface used to hide different types of Repositories for this app.
 */
interface IAdRepository {
    fun fetchAds(adsRequest: AdsRequest)
}