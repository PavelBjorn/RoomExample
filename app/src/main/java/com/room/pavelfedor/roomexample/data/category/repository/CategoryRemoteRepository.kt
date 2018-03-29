package com.room.pavelfedor.roomexample.data.category.repository

import com.room.pavelfedor.roomexample.data.base.api.Api
import com.room.pavelfedor.roomexample.data.base.repository.BaseRepository
import com.room.pavelfedor.roomexample.data.base.repository.RepositoryContainer
import com.room.pavelfedor.roomexample.data.category.entity.remoute.Category
import com.room.pavelfedor.roomexample.data.category.executor.CategoryApi


class CategoryRemoteRepository(override val executor: CategoryApi) : BaseRepository<CategoryRepositoryContainer, CategoryApi> {

    override fun get(query: Map<String, String>) = CategoryRepositoryContainer(
            executor.get(apiKey = Api.API_KEY, query = query).execute().body()?.data ?: listOf()
    )

    override fun update(dataContainer: CategoryRepositoryContainer, query: Map<String, String>) = dataContainer

    override fun remove(dataContainer: CategoryRepositoryContainer, query: Map<String, String>) = dataContainer

    override fun save(dataContainer: CategoryRepositoryContainer, query: Map<String, String>) = dataContainer

    override fun getContainerClass() = CategoryRepositoryContainer::class.java
}


class CategoryRepositoryContainer(data: List<Category>) : RepositoryContainer<List<Category>>(data)
