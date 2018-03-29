package com.room.pavelfedor.roomexample.data.base.repository


interface BaseRepository<Data : RepositoryContainer<*>, Executor> {

    val executor: Executor

    fun get(query: Map<String, String> = mapOf()): Data

    fun update(dataContainer: Data, query: Map<String, String> = mapOf()): Data

    fun remove(dataContainer: Data, query: Map<String, String> = mapOf()): Data

    fun save(dataContainer: Data, query: Map<String, String> = mapOf()): Data

    fun getContainerClass(): Class<Data>

    fun toBaseRepository() = this as BaseRepository<RepositoryContainer<*>, *>
}

abstract class RepositoryContainer<out Data>(val data: Data)
