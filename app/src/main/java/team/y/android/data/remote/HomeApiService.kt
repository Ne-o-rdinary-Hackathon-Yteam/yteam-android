package team.y.android.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import team.y.android.data.model.HomeResponse

interface HomeApiService {

    @GET("/home/view/{token}")
    suspend fun getHome(
        @Path("token") req: String,
    ): HomeResponse
}
