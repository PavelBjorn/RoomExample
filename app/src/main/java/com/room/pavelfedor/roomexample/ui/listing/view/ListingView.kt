package com.room.pavelfedor.roomexample.ui.listing.view

import android.content.Context
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.util.AttributeSet
import android.widget.Toast
import com.room.pavelfedor.roomexample.data.product.entity.local.ProductEntity
import com.room.pavelfedor.roomexample.ui.base.view.BaseView
import com.room.pavelfedor.roomexample.ui.listing.adapter.ListingAdapter
import com.room.pavelfedor.roomexample.ui.listing.model.BaseListingModel
import com.room.pavelfedor.roomexample.ui.listing.presenter.BaseListingPresenter
import kotlinx.android.synthetic.main.list_view.view.*


class ListingView : CoordinatorLayout, BaseView {

    var arguments: Bundle? = null
    lateinit var presenter: BaseListingPresenter<out BaseListingModel>

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onFinishInflate() {
        super.onFinishInflate()
        if (!isInEditMode) initChildren()
    }

    override fun displayError(throwable: Throwable) {
        Toast.makeText(context, throwable.message, Toast.LENGTH_LONG).show()
    }

    override fun showProgress(progressCount: Int, interminable: Boolean) {
        srlUpdateList.isRefreshing = true
    }

    override fun dismissProgress() {
        srlUpdateList.isRefreshing = false
    }

    override fun initChildren() {
        srlUpdateList.setOnRefreshListener {
            presenter.getProducts(arguments ?: Bundle())
        }
        rvProducts.adapter = ListingAdapter()
    }

    override fun setArgs(args: Bundle) {
        arguments = args
    }

    fun displayProducts(products: List<ProductEntity>, clear: Boolean = true) {
        (rvProducts.adapter as ListingAdapter).apply {
            if (clear) clear()
            addAll(products)
        }
    }
}
