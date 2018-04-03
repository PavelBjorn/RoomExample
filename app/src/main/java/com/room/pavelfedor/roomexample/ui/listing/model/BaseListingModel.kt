package com.room.pavelfedor.roomexample.ui.listing.model

import com.room.pavelfedor.roomexample.data.product.entity.local.ProductEntity
import com.room.pavelfedor.roomexample.data.product.repository.ProductEntityRepositoryContainer
import com.room.pavelfedor.roomexample.ui.base.model.BaseModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

abstract class BaseListingModel : BaseModel() {

    abstract fun getProducts(query: Map<String, String>): Single<List<ProductEntity>>

    fun switchFavoriteStatus(item: ProductEntity) {
        repositoryInteractor.run {
            getFromRepository(ProductEntityRepositoryContainer::class.java,
                    mapOf(ProductEntity.ID_COLUMN to item.id.toString())
            ).map { it.data.isEmpty() }
                    .flatMap {
                        ProductEntityRepositoryContainer(data = mutableListOf(item)).run {
                            if (it) saveToRepository(this)
                            else removeFromRepository(this)
                        }
                    }
        }
    }
}
