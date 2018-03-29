package com.room.pavelfedor.roomexample.data.category.mappery

import com.room.pavelfedor.roomexample.data.base.mappery.BaseConverter
import com.room.pavelfedor.roomexample.data.category.entity.local.CategoryEntity
import com.room.pavelfedor.roomexample.data.category.entity.remoute.Category

class CategoryToCategoryEntityConverter : BaseConverter<Category, CategoryEntity> {
    override fun convert(source: Category) = CategoryEntity(
            id = source.id,
            fullTitle = source.fullTitle,
            title = source.title
    )
}
