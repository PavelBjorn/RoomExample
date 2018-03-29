package com.room.pavelfedor.roomexample.ui.listing.model

import com.room.pavelfedor.roomexample.data.product.entity.local.ProductEntity
import com.room.pavelfedor.roomexample.data.product.repository.ProductEntityRepositoryContainer
import com.room.pavelfedor.roomexample.ui.base.model.BaseModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

abstract class BaseListingModel : BaseModel() {

    abstract fun getProducts(): Single<List<ProductEntity>>

    open fun updateProducts(products: List<ProductEntity>) = repositoryInteractor.updateRepository(
            ProductEntityRepositoryContainer(products.toMutableList())
    ).map { it.data }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}
