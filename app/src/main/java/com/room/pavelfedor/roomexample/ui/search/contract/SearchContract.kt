package com.room.pavelfedor.roomexample.ui.search.contract

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import com.room.pavelfedor.roomexample.polaris.contract.PolarisContract
import com.room.pavelfedor.roomexample.ui.search.presenter.SearchPresenter

class SearchContract() : PolarisContract {

    override val view: PolarisContract.PolarisView
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val uiEventDispatcher: PolarisContract.UiEventDispatcher
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun describeContents() = 0

    override val presenter: PolarisContract.PolarisPresenter<*> = SearchPresenter()

    constructor(parcel: Parcel) : this() {

    }

    companion object CREATOR : Parcelable.Creator<SearchContract> {
        override fun createFromParcel(parcel: Parcel): SearchContract {
            return SearchContract(parcel)
        }

        override fun newArray(size: Int): Array<SearchContract?> {
            return arrayOfNulls(size)
        }
    }

}
