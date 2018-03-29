package com.room.pavelfedor.roomexample.ui.listing.presenter

import com.room.pavelfedor.roomexample.ui.base.presenter.BasePresenter
import com.room.pavelfedor.roomexample.ui.listing.model.BaseListingModel
import com.room.pavelfedor.roomexample.ui.listing.view.ListingView

abstract class BaseListingPresenter<Model : BaseListingModel> : BasePresenter<Model, ListingView> {

    override fun takeView(view: ListingView) {
        if (this.view == null) this.view = view
    }

    override fun dropView() {
        view = null
    }

    fun getProducts(limit: Int = 20, offset: Int = 0){

    }

}
