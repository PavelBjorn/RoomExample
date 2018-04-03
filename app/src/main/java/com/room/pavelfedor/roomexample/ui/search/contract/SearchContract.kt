package com.room.pavelfedor.roomexample.ui.search.contract

import android.os.Bundle
import com.room.pavelfedor.roomexample.polaris.contract.PolarisContract
import com.room.pavelfedor.roomexample.ui.search.presenter.SearchPresenter

class SearchContract() : PolarisContract {

    override val presenter: PolarisContract.PolarisPresenter<*> = SearchPresenter()

    override val view: PolarisContract.PolarisView
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override val uiEventDispatcher: PolarisContract.UiEventDispatcher
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override val polarisViewState: Bundle
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
}
