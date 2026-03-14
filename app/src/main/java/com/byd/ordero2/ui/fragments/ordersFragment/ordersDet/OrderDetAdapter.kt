package com.byd.ordero2.ui.fragments.ordersFragment.ordersDet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.byd.ordero2.databinding.ItemOrdersDetBinding
import com.byd.ordero2.ui.utils.BaseAdapter

class OrderDetAdapter( private val onClick: (OrderDetItem) -> Unit = {}): BaseAdapter<OrderDetItem,ItemOrdersDetBinding>(OrderDetDiffCallback) {
    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): ItemOrdersDetBinding {
        return ItemOrdersDetBinding.inflate(inflater,parent,false)
    }

    override fun bind(
        binding: ItemOrdersDetBinding,
        item: OrderDetItem,
        position: Int
    ) {
        binding.txtName.text = item.name
        binding.txtSize.text = item.size
        binding.txtColor.text = item.color
        binding.imgProduct.setImageResource(item.img)
        binding.txtSelectedCount.text = item.selectedCount
        binding.txtOrderNum.text = item.id.toString()
        binding.root.setOnClickListener {
            onClick(item)
        }
    }

    object OrderDetDiffCallback: DiffUtil.ItemCallback<OrderDetItem>(){
        override fun areItemsTheSame(
            oldItem: OrderDetItem,
            newItem: OrderDetItem
        ): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: OrderDetItem,
            newItem: OrderDetItem
        ): Boolean {
            return oldItem.id==newItem.id
        }

    }
}