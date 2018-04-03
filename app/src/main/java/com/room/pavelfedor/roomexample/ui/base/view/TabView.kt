package com.room.pavelfedor.roomexample.ui.base.view

import android.content.Context
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.widget.Toast
import com.room.pavelfedor.roomexample.R
import com.room.pavelfedor.roomexample.polaris.contract.PolarisContract
import com.room.pavelfedor.roomexample.ui.base.adapter.NavModel
import com.room.pavelfedor.roomexample.ui.base.adapter.NavViewPagerAdapter
import com.room.pavelfedor.roomexample.ui.base.dispatcher.DefaultEventDispatcher
import com.room.pavelfedor.roomexample.ui.listing.presenter.FavoritePresenter
import kotlinx.android.synthetic.main.tab_view.view.*

class TabView : ConstraintLayout, BaseView {

    private lateinit var navViewPagerAdapter: NavViewPagerAdapter

    override val eventDispatcher: PolarisContract.UiEventDispatcher? = null

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

    }

    override fun dismissProgress() {

    }

    override fun initChildren() {
        navViewPagerAdapter = NavViewPagerAdapter(mutableListOf(
                NavModel(R.layout.search_view, "Search"),
                NavModel(R.layout.list_view, "Favorite", FavoritePresenter())
        ))

        vpTabContainer.adapter = navViewPagerAdapter
        tlNav.setupWithViewPager(vpTabContainer)
    }

    override fun getEventKey(): Any = if (id != -1) id else throw IllegalArgumentException("view should have id")
}
