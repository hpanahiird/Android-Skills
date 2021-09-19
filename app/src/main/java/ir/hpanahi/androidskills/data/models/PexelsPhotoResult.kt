package ir.hpanahi.androidskills.data.models

import com.google.gson.annotations.SerializedName

data class PexelsPhotoResult(
    @field:SerializedName("photos") val photos: ArrayList<PexelsPhoto>,
    @field:SerializedName("page") val page: Int,
    @field:SerializedName("per_page") val per_page: Int,
    @field:SerializedName("total_results") val total_results: Int,
    @field:SerializedName("prev_page") val prev_page: String,
    @field:SerializedName("next_page") val next_page: String
)
