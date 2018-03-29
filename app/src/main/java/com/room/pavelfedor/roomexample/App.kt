package com.room.pavelfedor.roomexample

import android.app.Application
import android.arch.persistence.room.Room
import com.room.pavelfedor.roomexample.data.base.api.Api
import com.room.pavelfedor.roomexample.data.base.db.AppDataBase
import com.room.pavelfedor.roomexample.data.base.interactor.RepositoryInteractor
import com.room.pavelfedor.roomexample.data.category.executor.CategoryApi
import com.room.pavelfedor.roomexample.data.category.repository.CategoryLocalRepository
import com.room.pavelfedor.roomexample.data.category.repository.CategoryRemoteRepository
import com.room.pavelfedor.roomexample.data.product.executor.ProductApi
import com.room.pavelfedor.roomexample.data.product.repository.ProductLocalRepository
import com.room.pavelfedor.roomexample.data.product.repository.ProductRemoteRepository

class App : Application() {

    private val api: Api = Api()
    private lateinit var db: AppDataBase

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(this, AppDataBase::class.java, "room-example").allowMainThreadQueries().build()

        repositoryInteractor = RepositoryInteractor with listOf(
                CategoryLocalRepository(db.getCategoryDao()).toBaseRepository(),
                CategoryRemoteRepository(api.create(CategoryApi::class.java)).toBaseRepository(),
                ProductLocalRepository(db.getProductDao()).toBaseRepository(),
                ProductRemoteRepository(api.create(ProductApi::class.java)).toBaseRepository()
        )
    }

    companion object {
        var repositoryInteractor: RepositoryInteractor? = null; private set
    }
}
