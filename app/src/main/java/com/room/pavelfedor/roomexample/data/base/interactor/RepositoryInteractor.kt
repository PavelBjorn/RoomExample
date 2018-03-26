package com.room.pavelfedor.roomexample.data.base.interactor

import com.room.pavelfedor.roomexample.data.base.repository.BaseRepository
import io.reactivex.Single

class RepositoryInteractor private constructor(
        private val repositories: MutableMap<Class<*>, BaseRepository<*, *>>
) {
    fun <Entity : Any> getFromRepository(entityClass: Class<Entity>, query: Map<String, String> = mapOf()) = createObservable {
        (repositories[entityClass] as? BaseRepository<Entity, Any>)?.get(query)
    }

    fun <Entity : Any> updateRepository(entity: Entity, query: Map<String, String> = mapOf()) = createObservable {
        (repositories[entity::class.java] as?  BaseRepository<Entity, Any>)?.update(entity, query)
    }

    fun <Entity : Any> removeFromRepository(entity: Entity, query: Map<String, String> = mapOf()) = createObservable {
        (repositories[entity::class.java] as?  BaseRepository<Entity, Any>)?.remove(entity, query)
    }

    fun <Entity : Any> saveToRepository(entity: Entity, query: Map<String, String>) {
        (repositories[entity::class.java] as?  BaseRepository<Entity, Any>)?.save(entity)
    }

    private fun <Entity> createObservable(action: () -> Entity) = Single.create<Entity> {
        if (!it.isDisposed)
            try {
                it.onSuccess(action.invoke())
            } catch (error: Exception) {
                it.onError(error)
            }
    }

    companion object {

        infix fun with(repositories: List<BaseRepository<*, *>>): RepositoryInteractor {
            return RepositoryInteractor(
                    repositories.asSequence()
                            .map { it.getDataClass() to it }
                            .toMap()
                            .toMutableMap()
            )
        }
    }
}

