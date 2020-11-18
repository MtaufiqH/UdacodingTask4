package id.taufiq.api.builder

import id.taufiq.api.client.ApiClient
import id.taufiq.helper.MyUrl.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created By Taufiq on 11/18/2020.
 *
 */
class BuildApi {

    companion object {


        private val interceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        private fun buildClient(): OkHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

        private fun buildRetrofit(): Retrofit {
            return Retrofit.Builder()
                .client(buildClient())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
        }

        fun buildApiService(): ApiClient =
            buildRetrofit().create(ApiClient::class.java)
    }

}