package com.room.pavelfedor.roomexample.data.category.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = CategoryLocalEntity.TABLE)
data class CategoryLocalEntity(
        @PrimaryKey @ColumnInfo(name = ID_COLUMN) val id: String = "",
        @ColumnInfo(name = TITLE_COLUMN) val title: String = "",
        @ColumnInfo(name = FULL_TITLE_COLUMN) val fullTitle: String = ""
) {
    companion object {
        const val TABLE = "category"
        const val ID_COLUMN = "_id"
        const val TITLE_COLUMN = "title"
        const val FULL_TITLE_COLUMN = "full_title"
    }
}
