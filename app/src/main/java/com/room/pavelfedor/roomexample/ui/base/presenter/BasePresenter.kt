package com.room.pavelfedor.roomexample.ui.base.presenter

import com.room.pavelfedor.roomexample.ui.base.model.BaseModel
import com.room.pavelfedor.roomexample.ui.base.view.BaseView

interface BasePresenter<Model : BaseModel, View : BaseView> {

    var view: View?

    var model: Model

    fun takeView(view: View)

    fun dropView()

    fun handleError(error: Throwable)
}
