package com.byd.ordero2.ui.fragments.productChart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.byd.ordero2.databinding.ItemSelectCountBinding
import com.byd.ordero2.ui.fragments.mainfragment.products.Product
import com.byd.ordero2.ui.fragments.mainfragment.products.ProductType
import com.byd.ordero2.ui.utils.BaseAdapter

class PCAdapter(
    private val onCountClick: (ChoosedItem, Int) -> Unit
): BaseAdapter<ChoosedItem, ItemSelectCountBinding>(PCDiffCallback) {
    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): ItemSelectCountBinding {
        return ItemSelectCountBinding.inflate(inflater , parent , false)
    }

    override fun bind(
        binding: ItemSelectCountBinding,
        item: ChoosedItem,
        position: Int
    ) {
        binding.txtAvailableCount.text = item.availableCount
        binding.txtSelectedCount.text = item.selectedCount
        binding.imgColor.setImageResource(item.img)

        when (item.type) {

            ProductType.CLOTHES -> {
                binding.txtSize.visibility = View.VISIBLE
                binding.txtColor.text = item.color
                binding.txtSize.text = item.size
            }

            ProductType.SPORT -> {
                binding.txtSize.visibility = View.VISIBLE
                binding.txtColor.text = item.color
                binding.txtSize.text = item.size
            }

            ProductType.MEDICAL -> {
                binding.sizeContainer.visibility = View.GONE
                binding.txtColor.text = item.color
            }

            ProductType.WOOD -> {
                binding.sizeContainer.visibility = View.GONE
                binding.txtRasvetka.text = "Материал:"
                binding.txtColor.text = item.color
            }

            ProductType.ACCESSORIES -> {
                binding.sizeContainer.visibility = View.GONE
                binding.txtRasvetka.text = "Материал:"
                binding.txtColor.text = item.color
            }
        }

        binding.txtChooseCount.setOnClickListener {
            onCountClick(item, position)
        }
    }
    object PCDiffCallback: DiffUtil.ItemCallback<ChoosedItem>(){
        override fun areItemsTheSame(
            oldItem: ChoosedItem,
            newItem: ChoosedItem
        ): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ChoosedItem,
            newItem: ChoosedItem
        ): Boolean {
            return oldItem == newItem
        }
//        override fun areContentsTheSame(
//            oldItem: ChoosedItem,
//            newItem: ChoosedItem
//        ): Boolean {
//            return oldItem.id==newItem.id
//        }

    }
}