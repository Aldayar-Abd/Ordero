package com.byd.ordero2.ui.fragments.productDet

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.byd.ordero2.databinding.ItemColorPickerBinding
import com.byd.ordero2.ui.utils.BaseAdapter

class ProductDetAdapter(
    private val isSelectable: Boolean = false,
    private val onClick: (ProductDetItem) -> Unit = {}
): BaseAdapter<ProductDetItem, ItemColorPickerBinding>(ProductDetDiffUtil) {
    private val selectedItems = mutableSetOf<Int>()
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

        if (isSelectable) {

            val isSelected = selectedItems.contains(item.id)

            binding.root.strokeWidth = if (isSelected) 4 else 1
            binding.root.strokeColor = if (isSelected)
                Color.parseColor("#2F80ED")
            else
                Color.parseColor("#E0E0E0")

            binding.root.setOnClickListener {

                if (selectedItems.contains(item.id)) {
                    selectedItems.remove(item.id)
                } else {
                    selectedItems.add(item.id)
                }

                notifyItemChanged(position)
                onClick(item)
            }

        } else {
            // ❗ отключаем клики
            binding.root.setOnClickListener(null)
            binding.root.strokeWidth = 1
            binding.root.strokeColor = Color.parseColor("#E0E0E0")
        }
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