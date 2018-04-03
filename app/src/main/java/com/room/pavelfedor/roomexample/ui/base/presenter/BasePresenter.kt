package com.room.pavelfedor.roomexample.ui.base.presenter

import com.room.pavelfedor.roomexample.polaris.contract.PolarisContract
import com.room.pavelfedor.roomexample.ui.base.model.BaseModel
import com.room.pavelfedor.roomexample.ui.base.view.BaseView

interface BasePresenter<Model : BaseModel, View : BaseView> : PolarisContract.PolarisPresenter<View> {

    var view: View?

    var model: Model

    fun handleError(error: Throwable)
}
