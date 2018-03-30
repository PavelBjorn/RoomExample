package com.room.pavelfedor.roomexample.data.category.executor

import android.arch.persistence.room.*
import com.room.pavelfedor.roomexample.data.category.entity.local.CategoryEntity

@Dao
interface CategoryDao {

    @Transaction
    @Query("SELECT * FROM ${CategoryEntity.TABLE} CASE :query WHEN ")
    fun get(query: String = ""): List<CategoryEntity>

    @Transaction
    @Insert
    fun insert(categories: List<CategoryEntity>)

    @Transaction
    @Delete
    fun delete(categories: List<CategoryEntity>)

    @Transaction
    @Update
    fun update(categories: List<CategoryEntity>)
}
