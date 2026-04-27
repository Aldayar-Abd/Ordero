package com.byd.ordero2.ui.fragments.activeProductsFragment

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
                nameProduct = "Футболка",
                nameShop = "Fashion Home",
                price = "350 c",
                imageProduct = R.drawable.prod,
                imageProfile = R.drawable.ic_prof1,
                isFavorite = false
            ),
            ActiveProductsItem(
                id = 1,
                nameProduct = "Футболка Oversize",
                nameShop = "Fashion Home",
                price = "350 c",
                imageProduct = R.drawable.ic_oversize,
                imageProfile = R.drawable.ic_prof1,
                isFavorite = false
            ),
            ActiveProductsItem(
                id = 2,
                nameProduct = "Худи Street",
                nameShop = "Fashion Home",
                price = "520 c",
                imageProduct = R.drawable.ic_clow,
                imageProfile = R.drawable.ic_prof1,
                isFavorite = false
            ),
            ActiveProductsItem(
                id = 3,
                nameProduct = "Лонгслив Basic",
                nameShop = "Fashion Home",
                price = "270 c",
                imageProduct = R.drawable.img_23,
                imageProfile = R.drawable.ic_prof1,
                isFavorite = false
            ),
            ActiveProductsItem(
                id = 4,
                nameProduct = "Куртка Winter",
                nameShop = "Fashion Home",
                price = "890 c",
                imageProduct = R.drawable.ic_cl2,
                imageProfile = R.drawable.ic_prof1,
                isFavorite = false
            ),
            ActiveProductsItem(
                id = 5,
                nameProduct = "Рубашка Classic",
                nameShop = "Fashion Home",
                price = "420 c",
                imageProduct = R.drawable.ic_cl3,
                imageProfile = R.drawable.ic_prof1,
                isFavorite = false
            ),

            ActiveProductsItem(
                id = 1,
                nameProduct = "Спортивная футболка",
                nameShop = "Fashion Home",
                price = "1200 c",
                imageProduct = R.drawable.img_9,
                imageProfile = R.drawable.ic_prof1,
                isFavorite = false
            ),
            ActiveProductsItem(
                id = 2,
                nameProduct = "Беговые кроссовки",
                nameShop = "Fashion Home",
                price = "2500 c",
                imageProduct = R.drawable.img_10,
                imageProfile = R.drawable.ic_prof1,
                isFavorite = false
            ),
            ActiveProductsItem(
                id = 3,
                nameProduct = "Шорты спортивные",
                nameShop = "Fashion Home",
                price = "900 c",
                imageProduct = R.drawable.img_11,
                imageProfile = R.drawable.ic_prof1,
                isFavorite = false
            ),
            ActiveProductsItem(
                id = 4,
                nameProduct = "Футбольная форма",
                nameShop = "Fashion Home",
                price = "3200 c",
                imageProduct = R.drawable.img_12,
                imageProfile = R.drawable.ic_prof1,
                isFavorite = false
            ),
            ActiveProductsItem(
                id = 5,
                nameProduct = "Спортивный костюм",
                nameShop = "Fashion Home",
                price = "1800 c",
                imageProduct = R.drawable.img_13,
                imageProfile = R.drawable.ic_prof1,
                isFavorite = false
            ),
            ActiveProductsItem(
                id = 6,
                nameProduct = "Футбольные бутсы",
                nameShop = "Fashion Home",
                price = "4000 c",
                imageProduct = R.drawable.img_14,
                imageProfile = R.drawable.ic_prof1,
                isFavorite = false
            ),

            ActiveProductsItem(
                id = 101,
                nameProduct = "Солнцезащитные очки",
                nameShop = "Fashion Home",
                price = "800 c",
                imageProduct = R.drawable.img_15,
                imageProfile = R.drawable.ic_prof1,
                isFavorite = false
            )
        )

        adapter.submitList(activeProducts)
    }


}