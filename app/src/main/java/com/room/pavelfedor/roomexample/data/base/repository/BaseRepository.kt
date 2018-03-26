package com.room.pavelfedor.roomexample.data.base.repository

import java.lang.reflect.ParameterizedType

interface BaseRepository<Data, Executor> {

    val executor: Executor

    fun get(query: Map<String, String> = mapOf()): Data

    fun update(data: Data, query: Map<String, String> = mapOf()): Data

    fun remove(data: Data, query: Map<String, String> = mapOf()): Data

    fun save(data: Data, query: Map<String, String> = mapOf()): Data

    fun getDataClass() = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<Data>

    fun toBaseRepository() = this as BaseRepository<Any, Any>
}
