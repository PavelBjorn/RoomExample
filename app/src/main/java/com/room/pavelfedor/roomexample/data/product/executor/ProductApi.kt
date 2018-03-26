package com.room.pavelfedor.roomexample.data.product.executor

import com.room.pavelfedor.roomexample.data.product.entity.remote.Product
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ProductApi {
    @GET("/listings/active")
    fun get(@QueryMap params: Map<String, String>): Call<Response<Product>>
}
