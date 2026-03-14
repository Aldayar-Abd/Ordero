package com.byd.ordero2.ui.fragments.ordersFragment.ordersDet

import androidx.navigation.fragment.findNavController
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
                name = "Футболка из хлопка",
                size = "M, L, XL, 2XL",
                color = "Красный",
                img = R.drawable.prod,

                selectedCount = "500 шт"
            ),
            OrderDetItem(
                id = 2,
                name = "Футболка из хлопка",
                size = "L, XL, 2XL, 3XL, 4XL",
                color = "Серый",
                img = R.drawable.prod,
                selectedCount = "300 шт"
            ),
            OrderDetItem(
                id = 3,
                name = "Классические брюки",
                size = "M, L, XL, 2XL",
                color = "Черный",
                img = R.drawable.img_prod2,
                selectedCount = "500 шт"
            ),
            OrderDetItem(
                id = 4,
                name = "Классические брюки",
                size = "S, M, L, XL",
                color = "Темно-синий",
                img = R.drawable.img_prod2,
                selectedCount = "1000 шт"
            ),
            OrderDetItem(
                id = 5,
                name = "Кепки мужские",
                size = "S, M, L",
                color = "Белый",
                img = R.drawable.img_cap,
                selectedCount = "2000 шт"
            ),
            OrderDetItem(
                id = 6,
                name = "Кепки мужские",
                size = "S, M, L",
                color = "Черный",
                img = R.drawable.img_cap,
                selectedCount = "1000 шт"
            ),

        )
        adapter.submitList(orders)
    }

    private fun setUpRv(){
        adapter = OrderDetAdapter()
        binding.rvOrders.adapter = adapter
        binding.rvOrders.layoutManager = LinearLayoutManager(requireContext())
    }

}