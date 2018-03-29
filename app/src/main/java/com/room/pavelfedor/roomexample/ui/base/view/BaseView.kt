package com.room.pavelfedor.roomexample.ui.base.view

import android.os.Bundle

interface BaseView {

    fun displayError(throwable: Throwable)

    fun showProgress(progressCount: Int = 0, interminable: Boolean = true)

    fun dismissProgress()

    fun initChildren()

    fun setArgs(args: Bundle)

}
