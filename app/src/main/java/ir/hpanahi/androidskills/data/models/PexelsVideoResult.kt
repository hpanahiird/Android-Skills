package ir.hpanahi.androidskills.data.models

data class PexelsVideoResult(
    val videos: ArrayList<PexelsVideo>,
    val url: String,
    val page: Int,
    val per_page: Int,
    val total_results: Int,
    val prev_page: String,
    val next_page: String
)
