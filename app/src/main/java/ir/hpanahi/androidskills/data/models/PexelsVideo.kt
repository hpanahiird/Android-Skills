package ir.hpanahi.androidskills.data.models

data class PexelsVideo(
    val id: Int,
    val width: Int,
    val height: Int,
    val url: String,
    val image: String,
    val duration: String,
    val user: PexelsVideoUser,
    val videoFiles: ArrayList<PexelsVideoFile>
)
