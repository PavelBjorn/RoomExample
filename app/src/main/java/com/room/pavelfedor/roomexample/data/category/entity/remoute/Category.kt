package com.room.pavelfedor.roomexample.data.category.entity.remoute

import com.google.gson.annotations.SerializedName

data class Category(
        @SerializedName(ID) val id: String = "",
        @SerializedName(TITLE) val title: String = "",
        @SerializedName(FULL_TITLE) val fullTitle: String = ""
) {
    companion object {
        const val ID = "category_id"
        const val TITLE = "short_name"
        const val FULL_TITLE = "long_name"
    }
}
