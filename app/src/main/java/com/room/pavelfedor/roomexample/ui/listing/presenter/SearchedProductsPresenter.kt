package com.room.pavelfedor.roomexample.ui.listing.presenter

import com.room.pavelfedor.roomexample.ui.listing.model.SearchedProductsModel

class SearchedProductsPresenter(val catId: String, val keyWord: String) : BaseListingPresenter<SearchedProductsModel>() {

    override var model: SearchedProductsModel = SearchedProductsModel()

    override fun getParams() = mapOf("category" to catId, "limit" to "20", "offset" to "0", "keywords" to keyWord)
}
