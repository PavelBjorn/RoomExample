package com.room.pavelfedor.roomexample.data.category.entity.remoute

import com.google.gson.annotations.SerializedName

data class Category(
        @SerializedName(ID) val id: String = "",
        @SerializedName(TITLE) val title: String = "",
        @SerializedName(FULL_TITLE) val fullTitle: String = ""
) {
    companion object {
        const val ID = "_id"
        const val TITLE = "title"
        const val FULL_TITLE = "full_title"
    }
}
