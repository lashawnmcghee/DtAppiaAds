package com.lashawn.dtappiaads.models

import com.fasterxml.jackson.annotation.JsonIgnore

data class Ad(
    val averageRatingImageURL: String? = null,
    val useInstallerBroadcast: String? = null,
    @JsonIgnore
    val metadata: Any? = null,
    val isRandomPick: String? = null,
    val reclickAttribution: String? = null,
    val clickProxyURL: String? = null,
    val numberOfDownloads: String? = null,
    val tstiEligible: String? = null,
    val rating: String? = null,
    val bidRate: String? = null,
    val categoryName: String? = null,
    val creativeId: String? = null,
    val minOSVersion: String? = null,
    val productName: String? = null,
    val callToAction: String? = null,
    val campaignDisplayOrder: String? = null,
    val appId: String? = null,
    val numberOfRatings: String? = null,
    val campaignTypeId: String? = null,
    val stiEnabled: String? = null,
    val enableAutoLaunch: String? = null,
    val productDescription: String? = null,
    val productId: String? = null,
    val installDelay: String? = null,
    val appPrivacyPolicyUrl: String? = null,
    val campaignId: String? = null,
    @JsonIgnore
    val externalMetadata: Any? = null,
    val homeScreen: String? = null,
    val impressionTrackingURL: String? = null,
    val postInstallActions: String? = null,
    val billingTypeId: String? = null,
    val productThumbnail: String? = null,
    val s2s: String? = null) {

    override fun toString(): String {
        val sb = StringBuilder()

        //TODO: Loop over class properties and get values for this object
        sb.appendLine("Name: $productName")
        sb.appendLine()
        sb.appendLine("Category Name: $categoryName")
        sb.appendLine()
        sb.appendLine("Rating: $rating")
        sb.appendLine()
        sb.appendLine("Description: $productDescription")
        sb.appendLine()
        sb.appendLine("Number Of Downloads: $numberOfDownloads")
        sb.appendLine()
        sb.appendLine("numberOfRatings: $numberOfRatings")
        sb.appendLine()
        sb.appendLine("productId: $productId")
        sb.appendLine()
        sb.appendLine("AverageRating: $averageRatingImageURL")
        sb.appendLine()
        sb.appendLine("bidRate: $bidRate")
        sb.appendLine()
        sb.appendLine("useInstallerBroadcast: $useInstallerBroadcast")
        sb.appendLine()
        sb.appendLine("isRandomPick: $isRandomPick")
        sb.appendLine()
        sb.appendLine("reclickAttribution: $reclickAttribution")
        sb.appendLine()
        sb.appendLine("clickProxyURL: $clickProxyURL")
        sb.appendLine()
        sb.appendLine("tstiEligible: $tstiEligible")
        sb.appendLine()
        sb.appendLine("bidRate: $bidRate")
        sb.appendLine()
        sb.appendLine("creativeId: $creativeId")
        sb.appendLine()
        sb.appendLine("minOSVersion: $minOSVersion")
        sb.appendLine()
        sb.appendLine("callToAction: $callToAction")
        sb.appendLine()
        sb.appendLine("campaignDisplayOrder: $campaignDisplayOrder")
        sb.appendLine()
        sb.appendLine("appId: $appId")
        sb.appendLine()
        sb.appendLine("campaignTypeId: $campaignTypeId")
        sb.appendLine()
        sb.appendLine("stiEnabled: $stiEnabled")
        sb.appendLine()
        sb.appendLine("enableAutoLaunch: $enableAutoLaunch")
        sb.appendLine()
        sb.appendLine("installDelay: $installDelay")
        sb.appendLine()
        sb.appendLine("appPrivacyPolicyUrl: $appPrivacyPolicyUrl")
        sb.appendLine()
        sb.appendLine("campaignId: $campaignId")
        sb.appendLine()
        sb.appendLine("homeScreen: $homeScreen")
        sb.appendLine()
        sb.appendLine("impressionTrackingURL: $impressionTrackingURL")
        sb.appendLine()
        sb.appendLine("postInstallActions: $postInstallActions")
        sb.appendLine()
        sb.appendLine("billingTypeId: $billingTypeId")
        sb.appendLine()
        sb.appendLine("s2s: $s2s")

        return sb.toString()
    }
}
