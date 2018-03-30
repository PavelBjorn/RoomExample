package com.room.pavelfedor.roomexample.ui.listing.presenter

import android.os.Bundle
import com.room.pavelfedor.roomexample.ui.listing.model.FavoriteModel

class FavoritePresenter : BaseListingPresenter<FavoriteModel>() {

    override var model: FavoriteModel = FavoriteModel()

    override fun convertToQuery(args: Bundle) = mapOf<String, String>()
}
