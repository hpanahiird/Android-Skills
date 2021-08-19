package ir.hpanahi.androidskills.data.models

data class Photo(
    val id: Int,
    val width: Int,
    val height: Int,
    val url: String,
    val photographer: String,
    val photographer_url: String,
    val photographer_id: String,
    val avg_color: String,
    val src: PhotoSources
)

data class PhotoSources(
    val original: String,
    val large: String,
    val large2x: String,
    val medium: String,
    val small: String,
    val portrait: String,
    val landscape: String,
    val tiny: String
)