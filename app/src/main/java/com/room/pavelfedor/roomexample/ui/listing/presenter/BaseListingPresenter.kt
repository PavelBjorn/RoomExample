package com.room.pavelfedor.roomexample.ui.listing.presenter

import android.os.Bundle
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

    fun getProducts(args: Bundle) {
        view?.showProgress()
        model.getProducts(convertToQuery(args))
                .subscribe(
                        {
                            view?.dismissProgress()
                            view?.displayProducts(it, args.getBoolean("clear", true))
                        },
                        {
                            view?.dismissProgress()
                            handleError(it)
                        })
    }

    override fun handleError(error: Throwable) {
        view?.displayError(error)
    }

    protected abstract fun convertToQuery(args: Bundle): Map<String, String>

}
