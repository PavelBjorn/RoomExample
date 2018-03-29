package com.room.pavelfedor.roomexample.ui.base.model

import com.room.pavelfedor.roomexample.App
import com.room.pavelfedor.roomexample.data.base.interactor.RepositoryInteractor

abstract class BaseModel {
    val repositoryInteractor = App.repositoryInteractor ?: RepositoryInteractor.with(listOf())
}
