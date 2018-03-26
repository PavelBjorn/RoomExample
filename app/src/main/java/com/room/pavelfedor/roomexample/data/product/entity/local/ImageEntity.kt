package com.room.pavelfedor.roomexample.data.product.entity.local

data class ImageEntity(val urls: Map<String, String>) {
    fun getUrls(size: String) = urls["url_$size"]
}
