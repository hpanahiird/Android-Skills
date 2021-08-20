package ir.hpanahi.androidskills.data.models

data class PexelsPhotoResult(
    val photos: ArrayList<PexelsPhoto>,
    val page: Int,
    val per_page: Int,
    val total_results: Int,
    val prev_page: String,
    val next_page: String
)
