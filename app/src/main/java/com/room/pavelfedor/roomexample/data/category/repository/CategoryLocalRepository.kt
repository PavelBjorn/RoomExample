package com.room.pavelfedor.roomexample.data.category.repository

import com.room.pavelfedor.roomexample.data.base.repository.BaseCachedRepository
import com.room.pavelfedor.roomexample.data.base.repository.RepositoryContainer
import com.room.pavelfedor.roomexample.data.category.entity.local.CategoryEntity
import com.room.pavelfedor.roomexample.data.category.executor.CategoryDao
import com.room.pavelfedor.roomexample.util.extension.replace

class CategoryLocalRepository(override val executor: CategoryDao)
    : BaseCachedRepository<CategoryEntityRepositoryContainer, CategoryDao>() {

    override var cachedData: CategoryEntityRepositoryContainer = CategoryEntityRepositoryContainer(mutableListOf())

    override fun get(query: Map<String, String>) = CategoryEntityRepositoryContainer(executor.get("WHERE ${CategoryEntity.TITLE_COLUMN} LIKE \"%a%\"").toMutableList())

    override fun update(dataContainer: CategoryEntityRepositoryContainer, query: Map<String, String>) = executor.update(dataContainer.data).let {
        cachedData.apply { this.data.replace(dataContainer.data) { old, new -> old.id == new.id } }
    }

    override fun remove(dataContainer: CategoryEntityRepositoryContainer, query: Map<String, String>) = executor.delete(dataContainer.data).let { dataContainer }

    override fun save(dataContainer: CategoryEntityRepositoryContainer, query: Map<String, String>) = executor.insert(dataContainer.data).let { dataContainer }

    override fun updateCache(dataContainer: CategoryEntityRepositoryContainer) {
        cachedData.data.clear()
        cachedData.data.addAll(dataContainer.data)
    }

    override fun getContainerClass() = CategoryEntityRepositoryContainer::class.java
}

class CategoryEntityRepositoryContainer(data: MutableList<CategoryEntity>)
    : RepositoryContainer<MutableList<CategoryEntity>>(data)
