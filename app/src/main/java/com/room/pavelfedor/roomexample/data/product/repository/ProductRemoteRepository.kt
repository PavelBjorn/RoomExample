package com.room.pavelfedor.roomexample.data.product.repository

import com.room.pavelfedor.roomexample.data.base.api.Api
import com.room.pavelfedor.roomexample.data.base.repository.BaseRepository
import com.room.pavelfedor.roomexample.data.base.repository.RepositoryContainer
import com.room.pavelfedor.roomexample.data.product.entity.remote.Product
import com.room.pavelfedor.roomexample.data.product.executor.ProductApi

class ProductRemoteRepository(override val executor: ProductApi) : BaseRepository<ProductRepositoryContainer, ProductApi> {

    override fun get(query: Map<String, String>) = ProductRepositoryContainer(executor.get(
            apiKey = Api.API_KEY,
            params = query).execute().body()?.data ?: listOf()
    )

    override fun update(dataContainer: ProductRepositoryContainer, query: Map<String, String>) = dataContainer

    override fun remove(dataContainer: ProductRepositoryContainer, query: Map<String, String>) = dataContainer

    override fun save(dataContainer: ProductRepositoryContainer, query: Map<String, String>) = dataContainer

    override fun getContainerClass() = ProductRepositoryContainer::class.java
}

class ProductRepositoryContainer(data: List<Product>) : RepositoryContainer<List<Product>>(data)
