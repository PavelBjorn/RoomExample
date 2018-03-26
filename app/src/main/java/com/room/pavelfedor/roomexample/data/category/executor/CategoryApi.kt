package com.room.pavelfedor.roomexample.data.category.executor
import com.room.pavelfedor.roomexample.data.category.entity.remoute.Category
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap
import retrofit2.http.Query as RetrofitQuery

interface CategoryApi {
    @GET("taxonomy/categories")
    fun get(@QueryMap query: Map<String, String>): Single<Category>
}

