package com.room.pavelfedor.roomexample.data.product.entity.local.mappery

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import com.room.pavelfedor.roomexample.data.product.entity.local.ImageEntity

class ImageDbTypeConverter {

    fun toJson(image: List<ImageEntity>) = Gson().toJson(image) ?: ""

    fun fromJson(json: String?): List<ImageEntity> {
        return try {
            Gson().fromJson<List<ImageEntity>>(json,
                    object : TypeToken<List<ImageEntity>>() {}.type) ?: listOf()
        } catch (exception: JsonSyntaxException) {
            listOf()
        }
    }
}
