package com.example.pago_android_junior.view_holders.generic

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class ListViewHolder<TItem>(viewBinding: ViewBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {
    /**
     * Bind an item of the dataset to the view
     */
    abstract fun bind(item: TItem)
}