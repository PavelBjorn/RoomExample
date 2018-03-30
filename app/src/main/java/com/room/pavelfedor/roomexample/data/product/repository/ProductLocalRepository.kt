package com.room.pavelfedor.roomexample.data.product.repository

import com.room.pavelfedor.roomexample.data.base.repository.BaseCachedRepository
import com.room.pavelfedor.roomexample.data.base.repository.RepositoryContainer
import com.room.pavelfedor.roomexample.data.product.entity.local.ProductEntity
import com.room.pavelfedor.roomexample.data.product.executor.ProductDao
import com.room.pavelfedor.roomexample.util.extension.replace
import java.lang.IllegalArgumentException

class ProductLocalRepository(override val executor: ProductDao) : BaseCachedRepository<ProductEntityRepositoryContainer, ProductDao>() {

    override var cachedData: ProductEntityRepositoryContainer = ProductEntityRepositoryContainer(mutableListOf())

    override fun get(query: Map<String, String>) = ProductEntityRepositoryContainer(executor.get(formQuery(query))
            .toMutableList())

    override fun updateCache(dataContainer: ProductEntityRepositoryContainer) {
        cachedData.data.clear()
        cachedData.data.addAll(dataContainer.data)
    }

    override fun update(dataContainer: ProductEntityRepositoryContainer, query: Map<String, String>) = executor.update(dataContainer.data).let {
        cachedData.apply { data.replace(dataContainer.data, { old, new -> old.id == new.id }) }
    }

    override fun remove(dataContainer: ProductEntityRepositoryContainer, query: Map<String, String>) = executor.delete(dataContainer.data).let {
        cachedData.apply { data.removeAll(dataContainer.data) }
    }

    override fun save(dataContainer: ProductEntityRepositoryContainer, query: Map<String, String>) = executor.insert(dataContainer.data).let {
        cachedData.apply { data.addAll(dataContainer.data) }
    }

    override fun getContainerClass() = ProductEntityRepositoryContainer::class.java

    private fun formQuery(params: Map<String, String>): String {
        return ("REMOVE_" + params.map { "AND WHERE ${it.key} = ${it.value}" }.toList().joinToString { it }).replace("REMOVE_AND", "")
    }
}

class ProductEntityRepositoryContainer(data: MutableList<ProductEntity>) : RepositoryContainer<MutableList<ProductEntity>>(data)
