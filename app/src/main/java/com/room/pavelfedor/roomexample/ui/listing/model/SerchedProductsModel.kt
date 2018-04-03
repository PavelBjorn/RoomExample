package com.room.pavelfedor.roomexample.ui.listing.model

import com.room.pavelfedor.roomexample.data.product.entity.local.ProductEntity
import com.room.pavelfedor.roomexample.data.product.entity.mappery.ImageToImageEntityConverter
import com.room.pavelfedor.roomexample.data.product.entity.mappery.ProductToProducEntityConverter
import com.room.pavelfedor.roomexample.data.product.repository.ProductRepositoryContainer
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchedProductsModel : BaseListingModel() {
    override fun getProducts(query: Map<String, String>): Single<List<ProductEntity>> {
        return repositoryInteractor.getFromRepository(ProductRepositoryContainer::class.java, query)
                .map { it.data.map { ProductToProducEntityConverter(ImageToImageEntityConverter()).convert(it) } }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}
