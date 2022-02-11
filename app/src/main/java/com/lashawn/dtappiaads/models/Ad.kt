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
        sb.appendLine("Minimum OS Version: $minOSVersion")
        sb.appendLine()
        sb.appendLine("App Id: $appId")
        sb.appendLine()
        sb.appendLine("Number Of Downloads: $numberOfDownloads")
        sb.appendLine()
        sb.appendLine("Number Of Ratings: $numberOfRatings")
        sb.appendLine()
        sb.appendLine("===Extra Info===")
        sb.appendLine()
        sb.appendLine("Product Id: $productId")
        sb.appendLine()
        sb.appendLine("Bid Rate: $bidRate")
        sb.appendLine()
        sb.appendLine("Use Installer Broadcast: $useInstallerBroadcast")
        sb.appendLine()
        sb.appendLine("Is Random Pick: $isRandomPick")
        sb.appendLine()
        sb.appendLine("Re-click Attribution: $reclickAttribution")
        sb.appendLine()
        sb.appendLine("Click Proxy URL: $clickProxyURL")
        sb.appendLine()
        sb.appendLine("TSTI Eligible: $tstiEligible")
        sb.appendLine()
        sb.appendLine("Creative Id: $creativeId")
        sb.appendLine()
        sb.appendLine("Call To Action: $callToAction")
        sb.appendLine()
        sb.appendLine("Campaign Display Order: $campaignDisplayOrder")
        sb.appendLine()
        sb.appendLine("campaignTypeId: $campaignTypeId")
        sb.appendLine()
        sb.appendLine("STI Enabled: $stiEnabled")
        sb.appendLine()
        sb.appendLine("Enable Auto Launch: $enableAutoLaunch")
        sb.appendLine()
        sb.appendLine("Install Delay: $installDelay")
        sb.appendLine()
        sb.appendLine("App Privacy Policy Url: $appPrivacyPolicyUrl")
        sb.appendLine()
        sb.appendLine("Campaign Id: $campaignId")
        sb.appendLine()
        sb.appendLine("Home Screen: $homeScreen")
        sb.appendLine()
        sb.appendLine("Impression Tracking URL: $impressionTrackingURL")
        sb.appendLine()
        sb.appendLine("Post Install Actions: $postInstallActions")
        sb.appendLine()
        sb.appendLine("Billing Type Id: $billingTypeId")
        sb.appendLine()
        sb.appendLine("s2s: $s2s")

        return sb.toString()
    }
}
