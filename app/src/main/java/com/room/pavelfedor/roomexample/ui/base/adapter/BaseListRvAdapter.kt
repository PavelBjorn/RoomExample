package com.room.pavelfedor.roomexample.ui.base.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.room.pavelfedor.roomexample.util.extension.replace

abstract class BaseListRvAdapter<Item, ViewHolder : BaseListRvAdapter.AbstractViewHolder<Item>> : RecyclerView.Adapter<ViewHolder>() {

    private val items: MutableList<Item> = mutableListOf()

    fun addAll(items: Collection<Item>) {
        val startPos = items.size
        this.items.addAll(items)
        notifyItemRangeInserted(startPos, items.size)
    }

    fun add(item: Item) {
        val startPos = items.size
        items.add(item)
        notifyItemInserted(startPos)
    }

    fun clear() {
        val itemsSize = items.size
        items.clear()
        notifyItemRangeRemoved(0, itemsSize)
    }

    fun update(item: Item) {
        this.items.replace(item) { updateItemPredicate(it, item) }.apply {
            if (this != -1) notifyItemChanged(this)
        }
    }

    protected abstract fun updateItemPredicate(oldItem: Item, newItem: Item): Boolean

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    abstract class AbstractViewHolder<Item>(rootView: View) : RecyclerView.ViewHolder(rootView) {
        abstract fun bind(item: Item)
    }
}
