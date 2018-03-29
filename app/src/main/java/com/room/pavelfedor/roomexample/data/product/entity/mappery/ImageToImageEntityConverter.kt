package com.room.pavelfedor.roomexample.data.product.entity.mappery

import com.room.pavelfedor.roomexample.data.base.mappery.BaseConverter
import com.room.pavelfedor.roomexample.data.product.entity.local.ImageEntity
import com.room.pavelfedor.roomexample.data.product.entity.remote.Image

class ImageToImageEntityConverter : BaseConverter<Image, ImageEntity>{
    override fun convert(source: Image) =  ImageEntity( urls = source.urls)
}
