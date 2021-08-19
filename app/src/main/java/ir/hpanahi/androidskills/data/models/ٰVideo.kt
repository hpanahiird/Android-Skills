package ir.hpanahi.androidskills.data.models

data class Video(
    val id: Int,
    val width: Int,
    val height: Int,
    val url: String,
    val image: String,
    val duration: String,
    val user: VideoUser,
    val videoFiles: ArrayList<VideoFile>
)

data class VideoUser(
    val id: Int,
    val name: String,
    val url: String
)

data class VideoFile(
    val id: Int,
    val quality: String,
    val fileType: String,
    val width: Int,
    val height: Int,
    val link: String
)
