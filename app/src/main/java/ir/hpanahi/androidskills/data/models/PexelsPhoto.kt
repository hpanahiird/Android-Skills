package ir.hpanahi.androidskills.data.models

import com.google.gson.annotations.SerializedName

data class PexelsPhoto(
    @field:SerializedName("id") val id: Int,
    @field:SerializedName("width") val width: Int,
    @field:SerializedName("height") val height: Int,
    @field:SerializedName("url") val url: String,
    @field:SerializedName("photographer") val photographer: String,
    @field:SerializedName("photographer_url") val photographerUrl: String,
    @field:SerializedName("photographer_id") val photographerId: String,
    @field:SerializedName("avg_color") val avgColor: String,
    @field:SerializedName("src") val src: PexelsPhotoUrls
)