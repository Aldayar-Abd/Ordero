package com.byd.ordero2.ui.fragments.productDet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.byd.ordero2.databinding.ItemColorPickerBinding
import com.byd.ordero2.ui.utils.BaseAdapter

class ProductDetAdapter: BaseAdapter<ProductDetItem, ItemColorPickerBinding>(ProductDetDiffUtil) {
    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): ItemColorPickerBinding {
        return ItemColorPickerBinding.inflate(inflater, parent, false)
    }

    override fun bind(
        binding: ItemColorPickerBinding,
        item: ProductDetItem,
        position: Int
    ) {
        binding.txtColor.text = item.color
        binding.imgColor.setImageResource(item.img)
    }
    object ProductDetDiffUtil : DiffUtil.ItemCallback<ProductDetItem>() {
        override fun areItemsTheSame(
            oldItem: ProductDetItem,
            newItem: ProductDetItem
        ): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProductDetItem,
            newItem: ProductDetItem
        ): Boolean {
            return oldItem.id==newItem.id
        }
    }
}