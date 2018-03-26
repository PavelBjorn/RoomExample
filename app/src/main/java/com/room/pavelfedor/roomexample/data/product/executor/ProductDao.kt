package com.room.pavelfedor.roomexample.data.product.executor

import android.arch.persistence.room.*
import com.room.pavelfedor.roomexample.data.product.entity.local.ProductEntity

@Dao
interface ProductDao {

    @Query("SELECT * FROM ${ProductEntity.TABLE} WHERE ${ProductEntity.CATEGORY_ID_COLUMN} = :catId")
    fun get(catId: String): List<ProductEntity>

    @Insert
    fun insert(categories: List<ProductEntity>)

    @Delete
    fun delete(categories: List<ProductEntity>)

    @Update
    fun update(categories: List<ProductEntity>)
}
