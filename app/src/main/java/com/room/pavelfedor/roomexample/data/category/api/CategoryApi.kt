package com.room.pavelfedor.roomexample.data.category.api

import com.room.pavelfedor.roomexample.data.base.api.Response
import com.room.pavelfedor.roomexample.data.category.entity.remoute.Category
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap
import retrofit2.http.Query as RetrofitQuery

interface CategoryApi {
    @GET("taxonomy/categories")
    fun get(@QueryMap query: Map<String, String>): Call<Response<List<Category>>>
}

