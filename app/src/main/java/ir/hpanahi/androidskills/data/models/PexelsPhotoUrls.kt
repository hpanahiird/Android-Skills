package ir.hpanahi.androidskills.data.models

import com.google.gson.annotations.SerializedName

data class PexelsPhotoUrls(
    @field:SerializedName("original") val original: String,
    @field:SerializedName("large") val large: String,
    @field:SerializedName("large2x") val large2x: String,
    @field:SerializedName("medium") val medium: String,
    @field:SerializedName("small") val small: String,
    @field:SerializedName("portrait") val portrait: String,
    @field:SerializedName("landscape") val landscape: String,
    @field:SerializedName("tiny") val tiny: String
)
