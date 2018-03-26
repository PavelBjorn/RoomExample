package com.room.pavelfedor.roomexample.data.product.entity.local

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.room.pavelfedor.roomexample.data.product.entity.local.ProductEntity.Companion.TABLE

@Entity(tableName = TABLE)
data class ProductEntity(
        @PrimaryKey @ColumnInfo(name = ID_COLUMN) val id: Long = 0,
        @ColumnInfo(name = CATEGORY_ID_COLUMN) val categoryId: Long = 0,
        @ColumnInfo(name = TITLE_COLUMN) val title: String = "",
        @ColumnInfo(name = CURRENCY_COLUMN) val currencyCode: String = "",
        @ColumnInfo(name = PRICE_COLUMN) val price: Double = 0.0,
        @ColumnInfo(name = DESCRIPTION_COLUMN) val description: String = "",
        @ColumnInfo(name = IMAGES_COLUMN) val images: List<ImageEntity> = listOf()
) {
    companion object {
        const val TABLE = "product"
        const val ID_COLUMN = "_id"
        const val CATEGORY_ID_COLUMN = "cat_id"
        const val TITLE_COLUMN = "title"
        const val CURRENCY_COLUMN = "currency"
        const val PRICE_COLUMN = "price"
        const val DESCRIPTION_COLUMN = "description"
        const val IMAGES_COLUMN = "images"
    }
}