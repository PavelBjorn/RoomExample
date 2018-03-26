package com.room.pavelfedor.roomexample.data.base.repository

abstract class BaseCachedRepository<Data, Executor> : BaseRepository<Data, Executor> {

    protected abstract var cachedData: Data

    fun get(updateCache: Boolean = false, query: Map<String, String>): Data {
        if (updateCache) cachedData = this.get(query)
        return cachedData
    }
}
