package com.room.pavelfedor.roomexample.data.category.executor

import android.arch.persistence.room.*
import com.room.pavelfedor.roomexample.data.category.entity.local.CategoryEntity

@Dao
interface CategoryDao {

    @Query("SELECT * FROM ${CategoryEntity.TABLE}")
    fun get(): List<CategoryEntity>

    @Insert
    fun insert(categories: List<CategoryEntity>)

    @Delete
    fun delete(categories: List<CategoryEntity>)

    @Update
    fun update(categories: List<CategoryEntity>)
}
