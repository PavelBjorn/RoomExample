package com.room.pavelfedor.roomexample.ui.base.view

import com.room.pavelfedor.roomexample.polaris.contract.PolarisContract


interface BaseView : PolarisContract.PolarisView {

    fun displayError(throwable: Throwable)

    fun showProgress(progressCount: Int = 0, interminable: Boolean = true)

    fun dismissProgress()

    fun initChildren()
}
