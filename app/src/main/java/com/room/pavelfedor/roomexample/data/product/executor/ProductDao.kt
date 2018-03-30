package com.room.pavelfedor.roomexample.data.product.executor

import android.arch.persistence.room.*
import com.room.pavelfedor.roomexample.data.product.entity.local.ProductEntity

@Dao
interface ProductDao {

    @Transaction
    @Query("SELECT * FROM ${ProductEntity.TABLE} CASE :query")
    fun get(query: String = ""): List<ProductEntity>

    @Transaction
    @Insert
    fun insert(categories: List<ProductEntity>)

    @Transaction
    @Delete
    fun delete(categories: List<ProductEntity>)

    @Transaction
    @Update
    fun update(categories: List<ProductEntity>)
}
