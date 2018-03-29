package com.room.pavelfedor.roomexample.data.category.executor

import com.room.pavelfedor.roomexample.data.base.api.Response
import com.room.pavelfedor.roomexample.data.category.entity.remoute.Category
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap
import retrofit2.http.Query

interface CategoryApi {
    @GET("taxonomy/categories")
    fun get(@Query(encoded = true, value = "api_key") apiKey: String,
            @QueryMap query: Map<String, String>): Call<Response<List<Category>>>
}
