package com.room.pavelfedor.roomexample.ui.search.view

import android.app.Activity
import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.room.pavelfedor.roomexample.R
import com.room.pavelfedor.roomexample.data.category.entity.local.CategoryEntity
import com.room.pavelfedor.roomexample.ui.base.stack.BackStackContextWrapper
import com.room.pavelfedor.roomexample.ui.base.stack.StackItem
import com.room.pavelfedor.roomexample.ui.base.view.BaseView
import com.room.pavelfedor.roomexample.ui.listing.presenter.SearchedProductsPresenter
import com.room.pavelfedor.roomexample.ui.search.presenter.SearchPresenter
import kotlinx.android.synthetic.main.search_view.view.*

class SearchView : ConstraintLayout, BaseView {

    private var catAdapter: ArrayAdapter<CategoryEntity> = ArrayAdapter(context, R.layout.item_cat, android.R.id.text1)
    private val presenter = SearchPresenter()

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onFinishInflate() {
        super.onFinishInflate()
        if (!isInEditMode) initChildren()
    }

    override fun initChildren() {
        catAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        catAdapter.setNotifyOnChange(true)
        spCategories.adapter = catAdapter
        btnSearch.setOnClickListener {
            edtSearch.text.toString().apply {
                if (this.isNotBlank()) ((context as Activity).baseContext as? BackStackContextWrapper)?.backStack?.navigateTo(
                        parent as ViewGroup, StackItem(
                        layoutRes = R.layout.list_view,
                        args = SearchedProductsPresenter((spCategories.selectedItem as CategoryEntity).id, this)
                ))
            }
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        if (!isInEditMode) {
            presenter.takeView(this)
            presenter.getCategories()
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        if (!isInEditMode) presenter.dropView()
    }

    override fun displayError(throwable: Throwable) {
        Toast.makeText(context, throwable.message, Toast.LENGTH_LONG).show()
    }

    override fun showProgress(progressCount: Int, interminable: Boolean) {
        progress.visibility.apply { if (this != View.VISIBLE) progress.visibility = View.VISIBLE }
    }

    override fun dismissProgress() {
        progress.visibility.apply { if (this == View.VISIBLE) progress.visibility = View.GONE }
    }

    fun displayCategories(categories: List<CategoryEntity>) {
        catAdapter.clear()
        catAdapter.addAll(categories)
    }
}
