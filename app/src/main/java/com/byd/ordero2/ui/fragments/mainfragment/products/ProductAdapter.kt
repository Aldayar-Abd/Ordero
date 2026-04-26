package com.byd.ordero2.ui.fragments.mainfragment.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.byd.ordero2.R
import com.byd.ordero2.databinding.ItemProductsBinding
import com.byd.ordero2.ui.utils.BaseAdapter

class ProductAdapter(
    private val onClick: (Product) -> Unit = {}
) : BaseAdapter<Product, ItemProductsBinding>(ProductDiffCallback) {

    object ProductDiffCallback : DiffUtil.ItemCallback<Product>() {

        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return getId(oldItem) == getId(newItem)
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }

        private fun getId(product: Product): Int {
            return when (product) {
                is Product.Clothes -> product.id
                is Product.Medical -> product.id
                is Product.Wood -> product.id
                is Product.Sport -> product.id
                is Product.Accessories -> product.id
            }
        }
    }

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): ItemProductsBinding {
        return ItemProductsBinding.inflate(inflater, parent, false)
    }

    override fun bind(
        binding: ItemProductsBinding,
        item: Product,
        position: Int
    ) {

        when (item) {

            is Product.Clothes -> {
                binding.txtCategory.text = "Одежда"
                binding.imgProduct.setImageResource(item.img)
                binding.txtName.text = item.name
                binding.txtPrice.text = "${item.price} c"
                binding.txtNameShop.text = item.nameShop
                binding.imgProfile.setImageResource(item.imgShop)
            }

            is Product.Medical -> {
                binding.txtCategory.text = "Медтовары"
                binding.imgProduct.setImageResource(item.img)
                binding.txtName.text = item.name
                binding.txtPrice.text = "${item.price} c"
                binding.txtNameShop.text = item.nameShop
                binding.imgProfile.setImageResource(item.imgShop)
            }

            is Product.Wood -> {
                binding.txtCategory.text = "Строй материалы"
                binding.imgProduct.setImageResource(item.img)
                binding.txtName.text = item.name
                binding.txtPrice.text = "${item.price} c"
                binding.txtNameShop.text = item.nameShop
                binding.imgProfile.setImageResource(item.imgShop)
            }

            is Product.Sport -> {
                binding.txtCategory.text = "Спорт и хобби"
                binding.imgProduct.setImageResource(item.img)
                binding.txtName.text = item.name
                binding.txtPrice.text = "${item.price} c"
                binding.txtNameShop.text = item.nameShop
                binding.imgProfile.setImageResource(item.imgShop)
            }

            is Product.Accessories -> {
                binding.txtCategory.text = "Аксессуары"
                binding.imgProduct.setImageResource(item.img)
                binding.txtName.text = item.name
                binding.txtPrice.text = "${item.price} c"
                binding.txtNameShop.text = item.nameShop
                binding.imgProfile.setImageResource(item.imgShop)
            }
        }

        binding.root.setOnClickListener {
            onClick(item)
        }
    }
}
//
//class ProductAdapter(
//    private val onFavoriteClick: (ProductItem) -> Unit = {}
//) : BaseAdapter<ProductItem, ItemProductsBinding>(ProductDiffCallback) {
//
//    object ProductDiffCallback : DiffUtil.ItemCallback<ProductItem>() {
//        override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
//            return oldItem.id == newItem.id
//        }
//
//        override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
//            return oldItem == newItem
//        }
//    }
//
//    override fun createBinding(
//        inflater: LayoutInflater,
//        parent: ViewGroup
//    ): ItemProductsBinding {
//        return ItemProductsBinding.inflate(inflater, parent, false)
//    }
//
//    override fun bind(
//        binding: ItemProductsBinding,
//        item: ProductItem,
//        position: Int
//    ) {
//        binding.imgProduct.setImageResource(item.img)
//        binding.txtName.text = item.name
//        binding.txtPrice.text = "${item.price} c"
//        binding.txtCategory.text = item.category
//        binding.txtNameShop.text = item.nameShop
//        binding.imgProfile.setImageResource(item.imgShop)
//
//        binding.imgFavorite.setImageResource(
//            if (item.favorite) R.drawable.ic_heart
//            else R.drawable.ic_non_heart
//        )
//
//        binding.root.setOnClickListener {
//            onFavoriteClick(item)
//        }
//    }
//}