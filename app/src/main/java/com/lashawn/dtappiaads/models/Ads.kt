package com.lashawn.dtappiaads.models

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

data class Ads(
    val adListId: String? = null,
    val responseTime: String? = null,
    val totalCampaignsRequested: String? = null,
    val version: String? = null
) {
    @JacksonXmlProperty(localName = "ad")
    @JacksonXmlElementWrapper(useWrapping = false)
    val ads: List<Ad>? = null
}
