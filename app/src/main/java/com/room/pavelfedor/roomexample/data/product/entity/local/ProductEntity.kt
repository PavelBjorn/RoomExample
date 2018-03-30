package com.room.pavelfedor.roomexample.data.product.entity.local

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.room.pavelfedor.roomexample.data.product.entity.local.ProductEntity.Companion.TABLE

@Entity(tableName = TABLE)
data class ProductEntity(
        @PrimaryKey @ColumnInfo(name = ID_COLUMN) val id: Long,
        @ColumnInfo(name = CATEGORY_ID_COLUMN) val categoryId: Long,
        @ColumnInfo(name = TITLE_COLUMN) val title: String?,
        @ColumnInfo(name = CURRENCY_COLUMN) val currencyCode: String?,
        @ColumnInfo(name = PRICE_COLUMN) val price: Double?,
        @ColumnInfo(name = DESCRIPTION_COLUMN) val description: String?,
        @ColumnInfo(name = IMAGES_COLUMN) val images: List<ImageEntity> = listOf(),
        @ColumnInfo(name = FAVORITE_COLUMN) val favorite:Boolean
) {

    fun getFirstImage() = images.firstOrNull()

    fun getFullPrice() = "$price $currencyCode"

    companion object {
        const val TABLE = "product"
        const val ID_COLUMN = "_id"
        const val CATEGORY_ID_COLUMN = "cat_id"
        const val TITLE_COLUMN = "title"
        const val CURRENCY_COLUMN = "currency"
        const val PRICE_COLUMN = "price"
        const val DESCRIPTION_COLUMN = "description"
        const val IMAGES_COLUMN = "images"
        const val FAVORITE_COLUMN = "favorite"
    }
}
