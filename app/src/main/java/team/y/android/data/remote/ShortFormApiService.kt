package team.y.android.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface ShortFormApiService {

    @GET("/videos/get")
    suspend fun getVideos(
        @Query("page") page: Int,
    ): GetVideosResponse
}