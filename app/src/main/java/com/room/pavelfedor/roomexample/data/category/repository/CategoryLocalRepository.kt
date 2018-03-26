package com.room.pavelfedor.roomexample.data.category.repository

import com.room.pavelfedor.roomexample.data.base.repository.BaseCachedRepository
import com.room.pavelfedor.roomexample.data.category.entity.local.CategoryEntity
import com.room.pavelfedor.roomexample.data.category.executor.CategoryDao

class CategoryLocalRepository(override val executor: CategoryDao)
    : BaseCachedRepository<List<CategoryEntity>, CategoryDao>() {

    override var cachedData: List<CategoryEntity> = listOf()

    override fun get(query: Map<String, String>) = executor.get()

    override fun update(data: List<CategoryEntity>, query: Map<String, String>) = executor.update(data).let { data }

    override fun remove(data: List<CategoryEntity>, query: Map<String, String>) = executor.delete(data).let { data }

    override fun save(data: List<CategoryEntity>, query: Map<String, String>) = executor.insert(data).let { data }
}
