package com.room.pavelfedor.roomexample.ui.base.adapter

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.room.pavelfedor.roomexample.ui.base.view.BaseView

class NavViewPagerAdapter(private val navModels: MutableList<NavModel>) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return (LayoutInflater.from(container.context).inflate
        (navModels[position].layoutRes, container, false) as? BaseView)?.apply {
            setArgs(navModels[position].args)
            container.addView(this as View)
        } ?: throw IllegalArgumentException()

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any) = view == `object`

    override fun getCount() = navModels.size

    override fun getPageTitle(position: Int) = navModels[position].pageTitle
}

class NavModel(
        @LayoutRes val layoutRes: Int,
        val pageTitle: String,
        val args: Bundle = Bundle()
)

