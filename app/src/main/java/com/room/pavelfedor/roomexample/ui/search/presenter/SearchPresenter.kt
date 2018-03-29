package com.room.pavelfedor.roomexample.ui.search.presenter

import com.room.pavelfedor.roomexample.data.category.entity.local.CategoryEntity
import com.room.pavelfedor.roomexample.ui.base.presenter.BasePresenter
import com.room.pavelfedor.roomexample.ui.search.model.SearchModel
import com.room.pavelfedor.roomexample.ui.search.view.SearchView

class SearchPresenter : BasePresenter<SearchModel, SearchView> {

    override var model: SearchModel = SearchModel()

    override var view: SearchView? = null

    override fun takeView(view: SearchView) {
        if (this.view == null) this.view = view
    }

    override fun dropView() {
        view = null
    }

    override fun handleError(error: Throwable) {
        view?.dismissProgress()
        view?.displayError(error)
    }

    private fun onCategoriesSuccess(categories: List<CategoryEntity>?) {
        view?.dismissProgress()
        view?.displayCategories(categories ?: listOf())
    }

    fun getCategories() {
        model.getCategories().map { it.data }.subscribe(::onCategoriesSuccess, ::handleError)
    }
}
