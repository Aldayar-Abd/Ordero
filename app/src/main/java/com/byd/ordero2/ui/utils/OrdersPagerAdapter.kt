package com.byd.ordero2.ui.utils

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.byd.ordero2.ui.fragments.activeProductsFragment.ActiveProductsFragment
import com.byd.ordero2.ui.fragments.ordersFragment.OrdersFragment

class OrdersPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ActiveProductsFragment()
            1 -> OrdersFragment()
            else -> ActiveProductsFragment()
        }
    }
}