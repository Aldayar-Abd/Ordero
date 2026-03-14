package com.byd.ordero2.ui.fragments.mainfragment

import android.graphics.Color
import android.view.Gravity
import android.widget.FrameLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.byd.ordero2.R
import com.byd.ordero2.databinding.FragmentMainBinding
import com.byd.ordero2.ui.fragments.mainfragment.category.CategoryAdapter
import com.byd.ordero2.ui.fragments.mainfragment.category.CategoryItem
import com.byd.ordero2.ui.fragments.mainfragment.products.ProductAdapter
import com.byd.ordero2.ui.fragments.mainfragment.products.ProductItem
import com.byd.ordero2.ui.utils.BaseFragment
import com.byd.ordero2.ui.utils.HorizontalSpaceItemDecoration
import com.google.android.material.snackbar.Snackbar


class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
    override fun setUpUI() {
        setUpCategoryRv()
        setUpProductRv()

        binding.btnCamera.setOnClickListener {
            val snackBar = Snackbar.make(
                requireActivity().findViewById(android.R.id.content),
                "+ Новый заказ",
                Snackbar.LENGTH_SHORT
            )

            val view = snackBar.view
            val params = view.layoutParams as FrameLayout.LayoutParams
            params.gravity = Gravity.TOP
            view.layoutParams = params

            view.setBackgroundColor(Color.parseColor("#2F80ED"))
            snackBar.setTextColor(Color.WHITE)

            snackBar.show()


        }


    }
    private fun setUpCategoryRv(){
        val categories = listOf(
            CategoryItem("Техника", R.color.purple),
            CategoryItem("Одежда", R.color.purple2),
            CategoryItem("Спорт и хобби", R.color.yellow),
            CategoryItem("Инструменты", R.color.violet),
            CategoryItem("Медтовары", R.color.green),
            CategoryItem("Аксессуары", R.color.violet),
            CategoryItem("Оборудование для быта", R.color.purple)
        )

        binding.rvCategories.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.rvCategories.adapter = CategoryAdapter(categories)
        binding.rvCategories.addItemDecoration(HorizontalSpaceItemDecoration(10))
    }
    private fun setUpProductRv() {
        val products = listOf(
            ProductItem(
                id = 1,
                img = R.drawable.prod,
                price = 350,
                name = "Футболка из хлопка",
                category = "Одежда",
                favorite = true,
                nameShop = "Fashion home",
                imgShop = R.drawable.ic_prof1
            ),
            ProductItem(
                id = 2,
                img = R.drawable.img_cap,
                price = 420,
                name = "Кепка",
                category = "Одежда",
                favorite = false,
                nameShop = "Street wear",
                imgShop = R.drawable.ic_prof1
            ),
            ProductItem(
                id = 3,
                img = R.drawable.img_prod2,
                price = 280,
                name = "Классические брюки",
                category = "Аксессуары",
                favorite = true,
                nameShop = "Sport shop",
                imgShop = R.drawable.ic_prof1
            ),
            ProductItem(
                id = 4,
                img = R.drawable.khaki_shirt,
                price = 510,
                name = "Футболка",
                category = "Обувь",
                favorite = false,
                nameShop = "Sneaker store",
                imgShop = R.drawable.ic_prof1
            ),
            ProductItem(
                id = 5,
                img = R.drawable.prod,
                price = 199,
                name = "Базовая майка",
                category = "Одежда",
                favorite = false,
                nameShop = "Fashion home",
                imgShop = R.drawable.ic_prof1
            ),
            ProductItem(
                id = 6,
                img = R.drawable.img_bag,
                price = 760,
                name = "Рюкзак городской",
                category = "Аксессуары",
                favorite = true,
                nameShop = "Bag point",
                imgShop = R.drawable.ic_prof1
            )
        )

        val productAdapter = ProductAdapter{_->
            findNavController().navigate(R.id.productDetFragment)

        }

        binding.rvProducts.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvProducts.adapter = productAdapter

        productAdapter.submitList(products)
    }

}