package com.byd.ordero2.ui.fragments.productChart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.byd.ordero2.databinding.ItemSelectCountBinding
import com.byd.ordero2.ui.utils.BaseAdapter

class PCAdapter: BaseAdapter<PCItem, ItemSelectCountBinding>(PCDiffCallback) {
    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): ItemSelectCountBinding {
        return ItemSelectCountBinding.inflate(inflater , parent , false)
    }

    override fun bind(
        binding: ItemSelectCountBinding,
        item: PCItem,
        position: Int
    ) {
        binding.txtColor.text = item.color
        binding.txtSize.text = item.size
        binding.txtAvailableCount.text = item.availableCount
        binding.txtSelectedCount.text = item.selectedCount
        binding.imgColor.setImageResource(item.img)
    }
    object PCDiffCallback: DiffUtil.ItemCallback<PCItem>(){
        override fun areItemsTheSame(
            oldItem: PCItem,
            newItem: PCItem
        ): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: PCItem,
            newItem: PCItem
        ): Boolean {
            return oldItem.id==newItem.id
        }

    }
}