package com.room.pavelfedor.roomexample.data.category.dao

import android.arch.persistence.room.*
import com.room.pavelfedor.roomexample.data.category.entity.CategoryLocalEntity

@Dao
interface CategoryDao {

    @Query("SELECT * FROM ${CategoryLocalEntity.TABLE}")
    fun get(): List<CategoryLocalEntity>

    @Insert
    fun insert(categories: List<CategoryLocalEntity>)

    @Delete
    fun delete(categories: List<CategoryLocalEntity>)

    @Update
    fun update(categories: List<CategoryLocalEntity>)
}
