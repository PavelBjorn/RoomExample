package com.room.pavelfedor.roomexample.data.product.executor

import android.arch.persistence.db.SimpleSQLiteQuery
import android.arch.persistence.db.SupportSQLiteQuery
import android.arch.persistence.room.*
import com.room.pavelfedor.roomexample.data.product.entity.local.ProductEntity

@Dao
interface ProductDao {

    @Transaction
    @RawQuery
    fun get(query:SupportSQLiteQuery = SimpleSQLiteQuery("SELECT * FROM ${ProductEntity.TABLE}")): List<ProductEntity>

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
