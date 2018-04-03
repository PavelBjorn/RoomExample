package com.room.pavelfedor.roomexample.ui.listing.presenter

import com.room.pavelfedor.roomexample.ui.listing.model.FavoriteModel

class FavoritePresenter : BaseListingPresenter<FavoriteModel>() {

    override var model: FavoriteModel = FavoriteModel()

    override fun getParams(): Map<String, String> = mapOf()
}
