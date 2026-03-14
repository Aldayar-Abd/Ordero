package com.byd.ordero2.ui.fragments.chartfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.byd.ordero2.databinding.ItemProductsInChartBinding
import com.byd.ordero2.ui.utils.BaseAdapter

class ChartAdapter: BaseAdapter<ChartItem, ItemProductsInChartBinding>(ChartDiffCallback) {
    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): ItemProductsInChartBinding {
        return ItemProductsInChartBinding.inflate(inflater,parent,false)
    }

    override fun bind(
        binding: ItemProductsInChartBinding,
        item: ChartItem,
        position: Int
    ) {
        binding.imgProduct.setImageResource(item.img)
        binding.txtName.text=item.name
        binding.txtColor.text=item.color
        binding.txtSelectedCount.text=item.selectedCount
    }

    object ChartDiffCallback: DiffUtil.ItemCallback<ChartItem>() {
        override fun areItemsTheSame(
            oldItem: ChartItem,
            newItem: ChartItem
        ): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ChartItem,
            newItem: ChartItem
        ): Boolean {
            return oldItem.id==newItem.id
        }

    }
}