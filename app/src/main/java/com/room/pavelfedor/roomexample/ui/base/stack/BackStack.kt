package com.room.pavelfedor.roomexample.ui.base.stack

import android.content.Context
import android.content.ContextWrapper
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.*

class BackStack {

    private val backStack: MutableMap<ViewGroup, LinkedList<StackItem>> = mutableMapOf()
    private var currentParentItem: MutableMap<ViewGroup, StackItem> = mutableMapOf()

    fun navigateTo(parent: ViewGroup, stackItem: StackItem): View {
        currentParentItem[parent]?.apply {
            if (saveToBackStack) {
                parent.removeView(this.inflateView(parent))
                putToBackStack(parent, this)
            }
        }

        currentParentItem[parent] = stackItem
        return stackItem.inflateView(parent).apply {
            parent.addView(this)
        }
    }

    fun navigateBack(parent: ViewGroup): Boolean {
        if (backStack[parent]?.isNotEmpty() != true) return false

        currentParentItem[parent]?.apply {
            parent.removeView(this.inflateView(parent))
        }

        currentParentItem[parent] = backStack[parent]?.pop()?.apply {
            this.inflateView(parent)
        } ?: return false

        return true
    }

    private fun putToBackStack(parent: ViewGroup, stackItem: StackItem) {
        backStack[parent]?.add(stackItem) ?: (
                backStack.put(parent, LinkedList<StackItem>().apply {
                    add(stackItem)
                }))
    }

    fun getCurrentItem(parent: ViewGroup): StackItem? {
        return currentParentItem[parent]
    }
}

open class StackItem(
        @LayoutRes private val layoutRes: Int,
        val saveToBackStack: Boolean = true,
        private val args: Any? = null
) {
    private var view: View? = null

    fun inflateView(parent: ViewGroup): View {
        if (view == null) {
            view = LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)
        }
        return view!!
    }

    fun <Args> getArgs(): Args {
        return args as Args
    }
}

class BackStackContextWrapper(val backStack: BackStack, context: Context) : ContextWrapper(context)
