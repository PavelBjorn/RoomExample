package com.room.pavelfedor.roomexample.ui.listing.presenter

import com.room.pavelfedor.roomexample.ui.base.presenter.BasePresenter
import com.room.pavelfedor.roomexample.ui.listing.model.BaseListingModel
import com.room.pavelfedor.roomexample.ui.listing.view.ListingView

abstract class BaseListingPresenter<Model : BaseListingModel> : BasePresenter<Model, ListingView> {

    override var view: ListingView? = null

    override fun takeView(view: ListingView) {
        if (this.view == null) this.view = view
    }

    override fun dropView() {
        view = null
    }

    fun getProducts(clear: Boolean = true) {
        view?.showProgress()
        model.getProducts(getParams())
                .subscribe(
                        {
                            view?.dismissProgress()
                            view?.displayProducts(it, clear)
                        },
                        {
                            view?.dismissProgress()
                            handleError(it)
                        })
    }

    override fun handleError(error: Throwable) {
        view?.displayError(error)
    }

    protected abstract fun getParams(): Map<String, String>

}
