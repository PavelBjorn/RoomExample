package com.room.pavelfedor.roomexample

import android.app.Application
import android.arch.persistence.room.Room
import com.room.pavelfedor.roomexample.data.base.api.Api
import com.room.pavelfedor.roomexample.data.base.db.AppDataBase
import com.room.pavelfedor.roomexample.data.base.interactor.RepositoryInteractor
import com.room.pavelfedor.roomexample.data.category.api.CategoryApi
import com.room.pavelfedor.roomexample.data.category.repository.CategoryLocalRepository
import com.room.pavelfedor.roomexample.data.category.repository.CategoryRemoteRepository

class App : Application() {

    private val api: Api = Api()
    private val db: AppDataBase = Room.databaseBuilder(
            this,
            AppDataBase::class.java,
            "goods_searcher"
    ).build()

    override fun onCreate() {
        super.onCreate()
        repositoryInteractor = RepositoryInteractor with listOf(
                CategoryLocalRepository(db.getCategoryDao()).toBaseRepository(),
                CategoryRemoteRepository(api.create(CategoryApi::class.java)).toBaseRepository()
        )
    }

    companion object {
        lateinit var repositoryInteractor: RepositoryInteractor private set
    }
}
