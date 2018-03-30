package com.room.pavelfedor.roomexample.ui.listing.model

import com.room.pavelfedor.roomexample.data.product.repository.ProductEntityRepositoryContainer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FavoriteModel : BaseListingModel() {
    override fun getProducts(query: Map<String, String>) = repositoryInteractor.getFromRepository(
            ProductEntityRepositoryContainer::class.java, query
    ).map { it.data.toList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}
