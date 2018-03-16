package com.room.pavelfedor.roomexample.data.base.repository

import com.google.gson.Gson


interface BaseRepository<Data, Executor> {

    val executor: Executor

    fun <Q : Query<Executor, Data, *, *>> get(query: Q): Data

    fun <Q : Query<Executor, Data, *, *>> update(data: Data, query: Q)

    fun <Q : Query<Executor, Data, *, *>> remove(data: Data, query: Q)

    fun <Q : Query<Executor, Data, *, *>> save(data: Data, query: Q)
}

abstract class Query<Executor, Data, Key, Value>(val params: Map<Key, Value>) {

    private fun get(key: Key) = params[key] ?: throw IllegalArgumentException("No such key")

    private fun getKeys(): List<Key> = params.keys.toList()

    private fun toList() = params.map { it.value }

    private fun toJson() = Gson().toJson(params)

    abstract fun invoke(executor: Executor): Data
}
