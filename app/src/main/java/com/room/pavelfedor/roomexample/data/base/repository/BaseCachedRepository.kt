package com.room.pavelfedor.roomexample.data.base.repository

abstract class BaseCachedRepository<Data, Executor> : BaseRepository<Data, Executor> {
    protected abstract var cachedData: Data
}
