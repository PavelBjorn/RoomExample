package com.room.pavelfedor.roomexample.data.base.repository

abstract class BaseCachedRepository<Data: RepositoryContainer<*>, Executor> : BaseRepository<Data, Executor> {

    protected abstract var cachedData: Data

    fun get(updateCache: Boolean = false, query: Map<String, String>): Data {
        if (updateCache) updateCache(this.get(query))
        return cachedData
    }

    protected abstract fun updateCache(dataContainer: Data)
}
