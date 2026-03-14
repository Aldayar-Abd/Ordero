package com.byd.ordero2.ui.fragments.ordersFragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.byd.ordero2.databinding.ItemOrdersBinding
import com.byd.ordero2.ui.utils.BaseAdapter

class OrdersAdapter( private val onClick: (OrderItem) -> Unit = {}): BaseAdapter<OrderItem, ItemOrdersBinding>(OrdersDiffCallback) {
    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): ItemOrdersBinding {
        return ItemOrdersBinding.inflate(inflater,parent,false)
    }

    override fun bind(
        binding: ItemOrdersBinding,
        item: OrderItem,
        position: Int
    ) {
        binding.imgProfile.setImageResource(item.imageProfile)
        binding.txtFullName.text = item.fullName
        binding.root.setOnClickListener {
            onClick(item)
        }

    }
    object OrdersDiffCallback: DiffUtil.ItemCallback<OrderItem>(){
        override fun areItemsTheSame(
            oldItem: OrderItem,
            newItem: OrderItem
        ): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: OrderItem,
            newItem: OrderItem
        ): Boolean {
            return oldItem.id==newItem.id
        }

    }
}