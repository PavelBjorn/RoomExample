package com.room.pavelfedor.roomexample.data.product.entity.mappery

import com.room.pavelfedor.roomexample.data.base.mappery.BaseConverter
import com.room.pavelfedor.roomexample.data.product.entity.local.ProductEntity
import com.room.pavelfedor.roomexample.data.product.entity.remote.Product

class ProductToProducEntityConverter(private val imageEntityConverter: ImageToImageEntityConverter) : BaseConverter<Product, ProductEntity> {
    override fun convert(source: Product) = ProductEntity(
            id = source.id,
            categoryId = source.categoryId,
            title = source.title,
            description = source.description,
            currencyCode = source.currencyCode,
            price = source.price,
            images = source.images.asSequence().map { imageEntityConverter.convert(it) }.toList()
    )
}
