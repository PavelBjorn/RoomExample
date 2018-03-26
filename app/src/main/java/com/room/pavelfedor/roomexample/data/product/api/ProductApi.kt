package com.room.pavelfedor.roomexample.data.product.api

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ProductApi {
    @GET("/listings/active")
    fun get(@QueryMap params: Map<String, String>): Call<>
}
