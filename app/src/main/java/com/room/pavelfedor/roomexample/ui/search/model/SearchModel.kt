package com.room.pavelfedor.roomexample.ui.search.model

import com.room.pavelfedor.roomexample.data.category.mappery.CategoryToCategoryEntityConverter
import com.room.pavelfedor.roomexample.data.category.repository.CategoryEntityRepositoryContainer
import com.room.pavelfedor.roomexample.data.category.repository.CategoryRepositoryContainer
import com.room.pavelfedor.roomexample.data.product.entity.mappery.ImageToImageEntityConverter
import com.room.pavelfedor.roomexample.data.product.entity.mappery.ProductToProducEntityConverter
import com.room.pavelfedor.roomexample.data.product.repository.ProductRepositoryContainer
import com.room.pavelfedor.roomexample.ui.base.model.BaseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchModel : BaseModel() {

    fun getCategories() = repositoryInteractor.getFromRepository(CategoryRepositoryContainer::class.java).let {
        it.map { categoriesContainer ->
            CategoryToCategoryEntityConverter().let { converter ->
                categoriesContainer.data.asSequence().map { converter.convert(it) }.toList()
            }
        }.map { CategoryEntityRepositoryContainer(it.toMutableList()) }
                .flatMap { repositoryInteractor.saveToRepository(it) }
                .onErrorResumeNext { repositoryInteractor.getFromRepository(CategoryEntityRepositoryContainer::class.java) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun search(catId: String, query: String) {
        repositoryInteractor.getFromRepository(
                ProductRepositoryContainer::class.java,
                mapOf("keywords" to query, "category" to catId, "limit" to "20", "offset" to "0")
        ).map { productsContainer ->
            ProductToProducEntityConverter(ImageToImageEntityConverter()).let { converter ->
                productsContainer.data.asSequence().map { converter.convert(it) }.toList()
            }
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}
