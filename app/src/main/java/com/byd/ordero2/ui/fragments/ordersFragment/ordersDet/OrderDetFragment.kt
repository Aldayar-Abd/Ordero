package com.byd.ordero2.ui.fragments.ordersFragment.ordersDet

import androidx.recyclerview.widget.LinearLayoutManager
import com.byd.ordero2.R
import com.byd.ordero2.databinding.FragmentOrderDetBinding
import com.byd.ordero2.ui.utils.BaseFragment

class OrderDetFragment : BaseFragment<FragmentOrderDetBinding>(FragmentOrderDetBinding::inflate) {
    private lateinit var adapter: OrderDetAdapter
    override fun setUpUI() {
        setUpRv()
        setUpOrders()

    }

    private fun setUpOrders() {
        val orders = listOf(
            OrderDetItem(
                id = 1,
                name = "Футболка",
                size = "XS, S, M, L, XL, XXS, 2XL, 3XL",
                color = "Красный",
                img = R.drawable.prod,
                selectedCount = "1000 шт"
            ),
            OrderDetItem(
                id = 2,
                name = "Худи Street",
                size = "S, M, L",
                color = "Черный",
                img = R.drawable.ic_clow,
                selectedCount = "900 шт"
            ),
            OrderDetItem(
                id = 3,
                name = "Лонгслив Basic",
                size = "XS, S, M, L",
                color = "Серый",
                img = R.drawable.img_23,
                selectedCount = "2000 шт"
            ),
            OrderDetItem(
                id = 4,
                name = "Куртка Winter",
                size = "S, M, L",
                color = "Черный",
                img = R.drawable.ic_cl2,
                selectedCount = "500 шт"
            ),
            OrderDetItem(
                id = 5,
                name = "Рубашка Classic",
                size = "S, M, L",
                color = "Белый",
                img = R.drawable.ic_cl3,
                selectedCount = "1200 шт"
            )
        )
        adapter.submitList(orders)
    }

    private fun setUpRv(){
        adapter = OrderDetAdapter()
        binding.rvOrders.adapter = adapter
        binding.rvOrders.layoutManager = LinearLayoutManager(requireContext())
    }

}