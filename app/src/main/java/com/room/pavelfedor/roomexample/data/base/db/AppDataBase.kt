package com.room.pavelfedor.roomexample.data.base.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.room.pavelfedor.roomexample.data.category.entity.local.CategoryEntity
import com.room.pavelfedor.roomexample.data.category.executor.CategoryDao
import com.room.pavelfedor.roomexample.data.product.entity.local.ProductEntity
import com.room.pavelfedor.roomexample.data.product.entity.mappery.ImageDbTypeConverter
import com.room.pavelfedor.roomexample.data.product.executor.ProductDao

@Database(entities = [CategoryEntity::class, ProductEntity::class], version = 1)
@TypeConverters(ImageDbTypeConverter::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getCategoryDao(): CategoryDao
    abstract fun getProductDao(): ProductDao
}
