package com.room.pavelfedor.roomexample.data.product.repository

import com.room.pavelfedor.roomexample.data.base.api.Api
import com.room.pavelfedor.roomexample.data.base.repository.BaseRepository
import com.room.pavelfedor.roomexample.data.base.repository.RepositoryContainer
import com.room.pavelfedor.roomexample.data.product.entity.remote.Product
import com.room.pavelfedor.roomexample.data.product.executor.ProductApi

class ProductRemoteRepository(override val executor: ProductApi) : BaseRepository<ProductRepositoryContainer, ProductApi> {

    override fun get(query: Map<String, String>) = ProductRepositoryContainer(executor.get(apiKey = Api.API_KEY, params = query).execute().body()?.data
            ?: listOf())

    override fun update(data: ProductRepositoryContainer, query: Map<String, String>) = data

    override fun remove(data: ProductRepositoryContainer, query: Map<String, String>) = data

    override fun save(data: ProductRepositoryContainer, query: Map<String, String>) = data

    override fun getContainerClass() = ProductRepositoryContainer::class.java
}

class ProductRepositoryContainer(data: List<Product>) : RepositoryContainer<List<Product>>(data)
