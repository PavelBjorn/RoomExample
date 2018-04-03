package com.room.pavelfedor.roomexample.ui.base.adapter

import android.support.annotation.LayoutRes
import android.support.v4.view.PagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import com.room.pavelfedor.roomexample.ui.base.stack.BackStackContextWrapper
import com.room.pavelfedor.roomexample.ui.base.stack.StackItem

class NavViewPagerAdapter(private val navModels: MutableList<NavModel>) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return ((container.context as AppCompatActivity).baseContext as BackStackContextWrapper).backStack.navigateTo(
                container,
                navModels[position]
        )
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any) = view == `object`

    override fun getCount() = navModels.size

    override fun getPageTitle(position: Int) = navModels[position].pageTitle
}

class NavModel(
        @LayoutRes layoutRes: Int,
        val pageTitle: String,
        args: Any? = null
) : StackItem(layoutRes = layoutRes, saveToBackStack = false, args = args)

