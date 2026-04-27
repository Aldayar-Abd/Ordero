package com.byd.ordero2.ui.fragments.ordersFragment

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.byd.ordero2.R
import com.byd.ordero2.databinding.FragmentOrdersBinding
import com.byd.ordero2.ui.fragments.ordersFragment.adapter.OrderItem
import com.byd.ordero2.ui.fragments.ordersFragment.adapter.OrdersAdapter
import com.byd.ordero2.ui.utils.BaseFragment

class OrdersFragment : BaseFragment<FragmentOrdersBinding>(FragmentOrdersBinding::inflate) {
    private lateinit var adapter: OrdersAdapter
    override fun setUpUI() {
       setUpRv()
        setUpOrders()
    }
    private fun setUpRv(){
        adapter = OrdersAdapter{
            findNavController().navigate(R.id.orderDetFragment)
        }
        binding.rvOrders.adapter = adapter
        binding.rvOrders.layoutManager = LinearLayoutManager(requireContext())
    }
    private fun setUpOrders(){
        val orders = listOf(
            OrderItem(
                id = 1,
                fullName = "Андрей Иванов",
                imageProfile = R.drawable.img
            ),
            OrderItem(
                id = 2,
                fullName = "Наргиза Абдисаламова",
                imageProfile = R.drawable.ic_prof_woman2
            ),
            OrderItem(
                id = 3,
                fullName = "Дарья Алексеева",
                imageProfile = R.drawable.ic_woman6
            ),
            OrderItem(
                id = 4,
                fullName = "Актан Асанов",
                imageProfile = R.drawable.ic_prof_man3
            ),
            OrderItem(
                id = 5,
                fullName = "Узур Ислам уулу",
                imageProfile = R.drawable.ic_prof_man4
            ),
            OrderItem(
                id = 6,
                fullName = "Сергей Кузьмич",
                imageProfile = R.drawable.ic_prof_man1
            ))
        adapter.submitList(orders)
    }

}