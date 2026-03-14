package com.byd.ordero2.ui.utils


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseAdapter<T, VB : ViewBinding>(
    diffCallback: androidx.recyclerview.widget.DiffUtil.ItemCallback<T>
) : ListAdapter<T, BaseAdapter.BaseViewHolder<VB>>(diffCallback) {

    class BaseViewHolder<VB : ViewBinding>(
        val binding: VB
    ) : RecyclerView.ViewHolder(binding.root)

    abstract fun createBinding(inflater: LayoutInflater, parent: ViewGroup): VB

    abstract fun bind(binding: VB, item: T, position: Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VB> {
        return BaseViewHolder(createBinding(LayoutInflater.from(parent.context), parent))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<VB>, position: Int) {
        bind(holder.binding, getItem(position), position)
    }
}