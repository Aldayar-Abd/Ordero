package com.byd.ordero2.ui.fragments.productChart

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.byd.ordero2.R
import com.byd.ordero2.databinding.FragmentProductChartBinding
import com.byd.ordero2.ui.fragments.productDet.ProductDetAdapter
import com.byd.ordero2.ui.fragments.productDet.ProductDetItem
import com.byd.ordero2.ui.utils.BaseFragment


class ProductChartFragment : BaseFragment<FragmentProductChartBinding>(FragmentProductChartBinding::inflate) {
    private lateinit var rvSelectAdapter: PCAdapter
    private lateinit var rvColorsAdapter: ProductDetAdapter
    override fun setUpUI() {

        binding.btnConfirm.setOnClickListener {
            findNavController().navigate(R.id.mainFragment)
        }
        rvSelectAdapter = PCAdapter()
        binding.rvSelectCount.adapter = rvSelectAdapter
        binding.rvSelectCount.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rvColorsAdapter = ProductDetAdapter()
        binding.rvColors.adapter = rvColorsAdapter
        binding.rvColors.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        setUpItemsCount()
        setUpItemsColors()

    }
    private fun setUpItemsCount() {
        val items = listOf(
            PCItem(
                id = 1,
                size = "M",
                color = "Красный",
                availableCount = "220 шт",
                selectedCount = "50 шт",
                img = R.drawable.red_shirt
            ),
            PCItem(
                id = 2,
                size = "L",
                color = "Белый",
                availableCount = "200 шт",
                selectedCount = "100 шт",
                img = R.drawable.white_shirt
            ),
            PCItem(
                id = 3,
                size = "XL",
                color = "Черный",
                availableCount = "1500",
                selectedCount = "1000",
                img = R.drawable.black_shirt
            ),
            PCItem(
                id = 4,
                size = "S",
                color = "Серый",
                availableCount = "500 шт",
                selectedCount = "120 шт",
                img = R.drawable.gray_shirt
            )
        )

        rvSelectAdapter.submitList(items)
    }
    private fun setUpItemsColors() {
        val colors = listOf(
            ProductDetItem(1,R.drawable.red_shirt, "Красный"),
            ProductDetItem(2,R.drawable.white_shirt, "Белый"),
            ProductDetItem(3,R.drawable.gray_shirt, "Серый"),
            ProductDetItem(4,R.drawable.black_shirt, "Черный"),
            ProductDetItem(5,R.drawable.beige_shirt, "Бежевый"),
            ProductDetItem(6,R.drawable.khaki_shirt, "Хаки")
        )
        rvColorsAdapter.submitList(colors)
    }

}