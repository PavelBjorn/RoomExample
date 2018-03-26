package com.room.pavelfedor.roomexample.data.base.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.room.pavelfedor.roomexample.data.category.entity.local.CategoryEntity
import com.room.pavelfedor.roomexample.data.category.executor.CategoryDao

@Database(entities = [CategoryEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getCategoryDao(): CategoryDao
}
