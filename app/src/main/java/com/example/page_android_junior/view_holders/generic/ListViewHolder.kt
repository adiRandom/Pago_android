package com.example.page_android_junior.view_holders.generic

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class ListViewHolder<TItem>(viewBinding: ViewBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {
    abstract fun bind(item: TItem)
}