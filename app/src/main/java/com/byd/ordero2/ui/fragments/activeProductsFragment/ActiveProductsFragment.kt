package com.byd.ordero2.ui.fragments.activeProductsFragment

import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.byd.ordero2.R
import com.byd.ordero2.databinding.FragmentActiveProductsBinding
import com.byd.ordero2.ui.fragments.activeProductsFragment.adapter.ActiveProductsAdapter
import com.byd.ordero2.ui.fragments.activeProductsFragment.adapter.ActiveProductsItem
import com.byd.ordero2.ui.utils.BaseFragment

class ActiveProductsFragment : BaseFragment<FragmentActiveProductsBinding>(
    FragmentActiveProductsBinding::inflate) {
    private lateinit var adapter: ActiveProductsAdapter
    override fun setUpUI() {
        adapter = ActiveProductsAdapter()
        binding.rvActiveProducts.adapter = adapter
        binding.rvActiveProducts.layoutManager = GridLayoutManager(requireContext(),2)

        setUpActiveProductsRv()
    }

    private fun setUpActiveProductsRv() {
        val activeProducts = listOf(
            ActiveProductsItem(
                id = 1,
                nameProduct = "Футболка из хлопка",
                nameShop = "Fashion home",
                price = "350 c",
                imageProduct = R.drawable.prod,
                imageProfile = R.drawable.img,
                isFavorite = true
            ),
            ActiveProductsItem(
                id = 2,
                nameProduct = "Спортивные кроссовки",
                nameShop = "Sport line",
                price = "1200 c",
                imageProduct = R.drawable.prod,
                imageProfile = R.drawable.img,
                isFavorite = false
            ),
            ActiveProductsItem(
                id = 3,
                nameProduct = "Куртка зимняя",
                nameShop = "Winter style",
                price = "2400 c",
                imageProduct = R.drawable.prod,
                imageProfile = R.drawable.img,
                isFavorite = true
            ),
            ActiveProductsItem(
                id = 4,
                nameProduct = "Рюкзак городской",
                nameShop = "Urban shop",
                price = "890 c",
                imageProduct = R.drawable.prod,
                imageProfile = R.drawable.img,
                isFavorite = false
            ),
            ActiveProductsItem(
                id = 5,
                nameProduct = "Часы наручные",
                nameShop = "Time store",
                price = "1500 c",
                imageProduct = R.drawable.prod,
                imageProfile = R.drawable.img,
                isFavorite = true
            ),
            ActiveProductsItem(
                id = 6,
                nameProduct = "Наушники Bluetooth",
                nameShop = "Tech market",
                price = "2100 c",
                imageProduct = R.drawable.prod,
                imageProfile = R.drawable.img,
                isFavorite = false
            ),
            ActiveProductsItem(
                id = 7,
                nameProduct = "Толстовка oversize",
                nameShop = "Street wear",
                price = "980 c",
                imageProduct = R.drawable.prod,
                imageProfile = R.drawable.img,
                isFavorite = true
            ),
            ActiveProductsItem(
                id = 8,
                nameProduct = "Сумка через плечо",
                nameShop = "Bag point",
                price = "760 c",
                imageProduct = R.drawable.prod,
                imageProfile = R.drawable.img,
                isFavorite = false
            ),
            ActiveProductsItem(
                id = 9,
                nameProduct = "Джинсы классические",
                nameShop = "Denim style",
                price = "1300 c",
                imageProduct = R.drawable.prod,
                imageProfile = R.drawable.img,
                isFavorite = true
            )
        )

        adapter.submitList(activeProducts)
    }


}