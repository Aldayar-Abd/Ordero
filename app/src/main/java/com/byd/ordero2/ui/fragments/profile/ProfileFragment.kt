package com.byd.ordero2.ui.fragments.profile

import com.byd.ordero2.databinding.FragmentProfileBinding
import com.byd.ordero2.ui.utils.BaseFragment
import com.byd.ordero2.ui.utils.OrdersPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    private lateinit var pagerAdapter: OrdersPagerAdapter
    override fun setUpUI() {
        binding.viewPager.isUserInputEnabled = false
        setUpTabLayout()

    }
    private fun setUpTabLayout(){
        pagerAdapter = OrdersPagerAdapter(this)
        binding.viewPager.adapter = pagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Активные продукции"
                1 -> tab.text = "Заказы"
            }
        }.attach()
    }
}