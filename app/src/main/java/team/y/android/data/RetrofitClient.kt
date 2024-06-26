package team.y.android.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import team.y.android.data.remote.HomeApiService
import team.y.android.data.remote.ShortFormApiService

object RetrofitClient {
    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().apply {
                    addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                }.build())
                .build()
        }
        return retrofit!!
    }
}

private const val BASE_URL = "http://3.37.129.64:8080/"

const val ACCESS_TOKEN = "d6f6d982-cb17-4ce5-aab4-ba16e2e5f1d4"

val homeApiService: HomeApiService = RetrofitClient.getClient().create(HomeApiService::class.java)
val shortFormApiService: ShortFormApiService =
    RetrofitClient.getClient().create(ShortFormApiService::class.java)