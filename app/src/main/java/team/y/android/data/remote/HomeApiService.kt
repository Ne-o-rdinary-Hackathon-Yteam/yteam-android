package team.y.android.data.remote

import retrofit2.http.GET
import retrofit2.http.Query
import team.y.android.data.model.HomeResponse

interface HomeApiService {

    @GET("/home/view")
    suspend fun getHome(
        @Query("token") req: String,
    ): HomeResponse
}
