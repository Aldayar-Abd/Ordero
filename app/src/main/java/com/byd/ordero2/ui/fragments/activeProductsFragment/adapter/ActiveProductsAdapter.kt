package com.byd.ordero2.ui.fragments.activeProductsFragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.byd.ordero2.R
import com.byd.ordero2.databinding.ItemActiveProductsBinding
import com.byd.ordero2.ui.utils.BaseAdapter

class ActiveProductsAdapter( private val onClick: (ActiveProductsItem) -> Unit = {}): BaseAdapter<ActiveProductsItem, ItemActiveProductsBinding>(ActiveProductsDiffCallback) {
    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): ItemActiveProductsBinding {
        return ItemActiveProductsBinding.inflate(inflater, parent,false)
    }

    override fun bind(
        binding: ItemActiveProductsBinding,
        item: ActiveProductsItem,
        position: Int
    ) {
        binding.imgProduct.setImageResource(item.imageProduct)
        binding.imgProfile.setImageResource(item.imageProfile)
        binding.txtNameProduct.text=item.nameProduct
        binding.txtNameShop.text=item.nameShop
        binding.txtPrice.text = item.price
        if (item.isFavorite){
            binding.imgFavorite.setImageResource(R.drawable.ic_heart)
        }else{
            binding.imgFavorite.setImageResource(R.drawable.ic_non_heart)
        }
        binding.root.setOnClickListener {
            onClick(item)
        }

    }

    object ActiveProductsDiffCallback: DiffUtil.ItemCallback<ActiveProductsItem>(){
        override fun areItemsTheSame(
            oldItem: ActiveProductsItem,
            newItem: ActiveProductsItem
        ): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ActiveProductsItem,
            newItem: ActiveProductsItem
        ): Boolean {
            return oldItem.id==newItem.id
        }

    }
}