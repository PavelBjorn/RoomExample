package com.room.pavelfedor.roomexample.data.product.entity.remote

import com.google.gson.annotations.SerializedName

data class Product(
        @SerializedName("listing_id") val id: Long,
        @SerializedName("category_id") val categoryId: Long,
        @SerializedName("title") val title: String,
        @SerializedName("currency_code") val currencyCode: String,
        @SerializedName("price") val price: Double
)
