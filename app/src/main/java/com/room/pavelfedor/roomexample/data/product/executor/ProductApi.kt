package com.room.pavelfedor.roomexample.data.product.executor

import com.room.pavelfedor.roomexample.data.base.api.Response
import com.room.pavelfedor.roomexample.data.product.entity.remote.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ProductApi {
    @GET("listings/active")
    fun get(@Query("api_key") apiKey: String, @Query("includes") photo: String = "Images",
            @QueryMap params: Map<String, String>): Call<Response<List<Product>>>
}
