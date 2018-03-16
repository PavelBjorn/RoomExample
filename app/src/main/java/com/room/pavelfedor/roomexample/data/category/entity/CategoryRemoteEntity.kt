package com.room.pavelfedor.roomexample.data.category.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = CategoryLocalEntity.TABLE)
data class CategoryRemoteEntity(
        @PrimaryKey @ColumnInfo(name = ID) val id: String = "",
        @ColumnInfo(name = TITLE) val title: String = "",
        @ColumnInfo(name = FULL_TITLE) val fullTitle: String = ""
) {
    companion object {
        const val ID = "_id"
        const val TITLE = "title"
        const val FULL_TITLE = "full_title"
    }
}
