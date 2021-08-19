package ir.hpanahi.androidskills.data.models

data class PexelsPhoto(
    val id: Int,
    val width: Int,
    val height: Int,
    val url: String,
    val photographer: String,
    val photographerUrl: String,
    val photographerId: String,
    val avgColor: String,
    val src: PexelsPhotoUrls
)