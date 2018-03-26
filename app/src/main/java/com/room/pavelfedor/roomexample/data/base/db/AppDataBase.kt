package com.room.pavelfedor.roomexample.data.base.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.room.pavelfedor.roomexample.data.category.entity.local.CategoryEntity
import com.room.pavelfedor.roomexample.data.category.executor.CategoryDao
import com.room.pavelfedor.roomexample.data.product.entity.local.ImageEntity

@Database(entities = [CategoryEntity::class], version = 1)
@TypeConverters(ImageEntity::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getCategoryDao(): CategoryDao
}
