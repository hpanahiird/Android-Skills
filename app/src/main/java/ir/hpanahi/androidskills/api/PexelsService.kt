package ir.hpanahi.androidskills.api

import ir.hpanahi.androidskills.BuildConfig
import ir.hpanahi.androidskills.data.models.PexelsPhoto
import ir.hpanahi.androidskills.data.models.PexelsPhotoResult
import ir.hpanahi.androidskills.data.models.PexelsVideo
import ir.hpanahi.androidskills.data.models.PexelsVideoResult
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface PexelsService {

    @GET("v1/search")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("orientation") orientation: String,
        @Query("size") size: String,
        @Query("color") color: String,
        @Query("locale") locale: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Header("Authorization") auth: String = BuildConfig.PEXELS_API_KEY
    ): PexelsPhotoResult

    @GET("v1/curated")
    suspend fun curatedPhotos(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Header("Authorization") auth: String = BuildConfig.PEXELS_API_KEY
    ): PexelsPhotoResult

    @GET("v1/photo/{id}")
    suspend fun getPhoto(
        @Path("id", encoded = true) id: Int,
        @Header("Authorization") auth: String = BuildConfig.PEXELS_API_KEY
    ): PexelsPhoto

    @GET("videos/search")
    suspend fun searchVideos(
        @Query("query") query: String,
        @Query("orientation") orientation: String,
        @Query("size") size: String,
        @Query("locale") locale: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Header("Authorization") auth: String = BuildConfig.PEXELS_API_KEY
    ): PexelsVideoResult

    @GET("videos/popular")
    suspend fun popularVideos(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Header("Authorization") auth: String = BuildConfig.PEXELS_API_KEY
    ): PexelsVideoResult

    @GET("videos/videos/{id}")
    suspend fun getVideo(
        @Path("id", encoded = true) id: Int,
        @Header("Authorization") auth: String = BuildConfig.PEXELS_API_KEY
    ): PexelsVideo


    companion object {
        private const val BASE_URL = "https://api.pexels.com/"

        fun create(): PexelsService {
            val logger = HttpLoggingInterceptor().apply { level = Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PexelsService::class.java)
        }
    }
}