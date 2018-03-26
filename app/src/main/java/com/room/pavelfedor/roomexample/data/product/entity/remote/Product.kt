package com.room.pavelfedor.roomexample.data.product.entity.remote

import com.google.gson.annotations.SerializedName

data class Product(
        @SerializedName("listing_id") val id: Long = 0,
        @SerializedName("category_id") val categoryId: Long = 0,
        @SerializedName("title") val title: String = "",
        @SerializedName("currency_code") val currencyCode: String = "",
        @SerializedName("price") val price: Double = 0.0,
        @SerializedName("description") val description: String = "",
        @SerializedName("Images") val images: List<Image> = listOf()
)
