package com.room.pavelfedor.roomexample.data.base.api

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api(
        private val provider: Retrofit = Retrofit.Builder()
                .client(OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(Gson())).build()
) {
    fun <Api> create(apiClass: Class<Api>) = provider.create(apiClass)
}
