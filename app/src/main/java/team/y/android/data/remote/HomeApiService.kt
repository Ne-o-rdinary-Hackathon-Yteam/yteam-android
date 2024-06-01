package team.y.android.data.remote

import retrofit2.http.GET
import team.y.android.data.model.HomeResponse

interface HomeApiService {

    @GET("/home/view")
    suspend fun getHome(): HomeResponse
}
