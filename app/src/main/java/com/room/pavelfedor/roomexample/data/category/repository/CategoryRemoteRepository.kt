package com.room.pavelfedor.roomexample.data.category.repository

import com.room.pavelfedor.roomexample.data.base.repository.BaseRepository
import com.room.pavelfedor.roomexample.data.category.api.CategoryApi
import com.room.pavelfedor.roomexample.data.category.entity.remoute.Category


class CategoryRemoteRepository(override val executor: CategoryApi) : BaseRepository<List<Category>, CategoryApi> {

    override fun get(query: Map<String, String>) = executor.get(query).execute()
            .body()?.data ?: listOf()

    override fun update(data: List<Category>, query: Map<String, String>) = data

    override fun remove(data: List<Category>, query: Map<String, String>) = data

    override fun save(data: List<Category>, query: Map<String, String>) = data
}
