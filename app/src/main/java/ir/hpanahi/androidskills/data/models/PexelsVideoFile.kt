package ir.hpanahi.androidskills.data.models

data class PexelsVideoFile(
    val id: Int,
    val quality: String,
    val fileType: String,
    val width: Int,
    val height: Int,
    val link: String
)
