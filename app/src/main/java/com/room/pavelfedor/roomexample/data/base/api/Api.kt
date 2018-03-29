package com.room.pavelfedor.roomexample.data.base.api

import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api(
        private val provider: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpClient.Builder()
                        .addInterceptor(ErrorInterceptor())
                        .addInterceptor(HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        }).build())
                .addConverterFactory(GsonConverterFactory.create(Gson())).build()
) {
    fun <Api> create(apiClass: Class<Api>) = provider.create(apiClass)

    companion object {
        const val API_KEY = "q1j47d6k6k0r26wwz8l2clm6"
        const val BASE_URL = "https://openapi.etsy.com/v2/"
    }

    class ErrorInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain?) = chain?.proceed(chain.request())?.apply {
            if (code() != 200) throw Throwable(this.message())
        }
    }

}
