package com.room.pavelfedor.roomexample.data.base.interactor

import com.room.pavelfedor.roomexample.data.base.repository.BaseRepository
import com.room.pavelfedor.roomexample.data.base.repository.RepositoryContainer
import io.reactivex.Single
import java.lang.reflect.Type

class RepositoryInteractor private constructor(
        private val repositories: MutableMap<Type, BaseRepository<RepositoryContainer<*>, *>>
) {
    fun <Entity : RepositoryContainer<*>> getFromRepository(entityClass: Class<Entity>, query: Map<String, String> = mapOf()) = createObservable {
        repositories[entityClass]?.get(query) as Entity
    }

    fun <Entity : RepositoryContainer<*>> updateRepository(entity: Entity, query: Map<String, String> = mapOf()) = createObservable {
        repositories[entity::class.java]?.update(entity, query) as Entity
    }

    fun <Entity : RepositoryContainer<*>> removeFromRepository(entity: Entity, query: Map<String, String> = mapOf()) = createObservable {
        repositories[entity::class.java]?.remove(entity, query) as Entity
    }

    fun <Entity : RepositoryContainer<*>> saveToRepository(entity: Entity, query: Map<String, String> = mapOf()) = createObservable {
        repositories[entity::class.java]?.save(entity) as Entity
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

        infix fun with(repositories: List<BaseRepository<RepositoryContainer<*>, *>>): RepositoryInteractor {
            return RepositoryInteractor(
                    repositories.asSequence()
                            .map { it.getContainerClass() to it }
                            .toMap()
                            .toMutableMap()
            )
        }
    }
}

