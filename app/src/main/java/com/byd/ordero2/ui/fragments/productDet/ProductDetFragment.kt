package com.byd.ordero2.ui.fragments.productDet

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.byd.ordero2.R
import com.byd.ordero2.databinding.FragmentProductDetBinding
import com.byd.ordero2.ui.utils.BaseFragment


class ProductDetFragment : BaseFragment<FragmentProductDetBinding>(FragmentProductDetBinding::inflate) {
    private lateinit var  adapter : ProductDetAdapter
    override fun setUpUI() {
        setUpRv()
        setUpItems()
        binding.btnAddToCart.setOnClickListener {
            findNavController().navigate(R.id.productChartFragment)
        }
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.btnMsg.setOnClickListener {
            findNavController().navigate(R.id.chatFragment)
        }
    }

    private fun setUpItems() {
        val colors = listOf(
            ProductDetItem(1,R.drawable.red_shirt, "Красный"),
            ProductDetItem(2,R.drawable.white_shirt, "Белый"),
            ProductDetItem(3,R.drawable.gray_shirt, "Серый"),
            ProductDetItem(4,R.drawable.black_shirt, "Черный"),
            ProductDetItem(5,R.drawable.beige_shirt, "Бежевый"),
            ProductDetItem(6,R.drawable.khaki_shirt, "Хаки")
        )
        adapter.submitList(colors)
    }

    private fun setUpRv(){
        adapter = ProductDetAdapter()
        binding.rvColors.adapter = adapter
        binding.rvColors.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

    }

}