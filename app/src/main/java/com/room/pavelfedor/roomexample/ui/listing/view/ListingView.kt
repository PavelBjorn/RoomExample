package com.room.pavelfedor.roomexample.ui.listing.view

import android.content.Context
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.widget.Toast
import com.room.pavelfedor.roomexample.ui.base.view.BaseView


class ListingView : ConstraintLayout, BaseView {

    lateinit var arguments: Bundle

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun displayError(throwable: Throwable) {
        Toast.makeText(context, throwable.message, Toast.LENGTH_LONG).show()
    }

    override fun showProgress(progressCount: Int, interminable: Boolean) {

    }

    override fun dismissProgress() {

    }

    override fun initChildren() {

    }

    override fun setArgs(args: Bundle) {
        arguments = args
    }
}
