package com.room.pavelfedor.roomexample.ui.listing.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.room.pavelfedor.roomexample.R
import com.room.pavelfedor.roomexample.data.product.entity.local.ProductEntity
import com.room.pavelfedor.roomexample.ui.base.adapter.BaseListRvAdapter
import kotlinx.android.synthetic.main.item_product_list.view.*

class ListingAdapter : BaseListRvAdapter<ProductEntity, ListingAdapter.ListingViewHolder>() {

    override fun updateItemPredicate(oldItem: ProductEntity, newItem: ProductEntity) = oldItem.id == newItem.id

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ListingViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_product_list, parent, false)
    )

    class ListingViewHolder(rootView: View) : BaseListRvAdapter.AbstractViewHolder<ProductEntity>(rootView) {
        override fun bind(item: ProductEntity) {
            loadImage(item.getFirstImage()?.getUrl("570xN") ?: "", itemView.imvImage)
            itemView.tvTitle.text = item.title
            itemView.tvPrice.text = item.getFullPrice()
        }

        private fun loadImage(url: String, image: ImageView) {
            Glide.with(itemView.context.applicationContext).clear(image)
            Glide.with(itemView.context.applicationContext).load(url).into(image)
        }
    }
}
