package com.byd.ordero2.ui.fragments.chartfragment

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.byd.ordero2.R
import com.byd.ordero2.databinding.FragmentChartBinding
import com.byd.ordero2.ui.utils.BaseFragment

class ChartFragment : BaseFragment<FragmentChartBinding>(FragmentChartBinding::inflate) {
    private lateinit var adapter: ChartAdapter
    override fun setUpUI() {
        initRv()
        setUpRecyclerView()
        clickBack()
    }
    private fun setUpRecyclerView(){

        val products = listOf(
            ChartItem(
                id = 1,
                R.drawable.prod,
                name = "Футболка из хлопка",
                color = "Белый",
                selectedCount = "2000 шт",
                isSelected = true
            ),
            ChartItem(
                id = 1,
                R.drawable.prod,
                name = "Футболка из хлопка",
                color = "Белый",
                selectedCount = "2000 шт",
                isSelected = true
            ),
            ChartItem(
                id = 1,
                R.drawable.prod,
                name = "Футболка из хлопка",
                color = "Белый",
                selectedCount = "2000 шт",
                isSelected = true
            ))
        adapter.submitList(products)
    }
    private fun initRv(){
        adapter = ChartAdapter()
        binding.rvProducts.adapter = adapter
        binding.rvProducts.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL,false)
    }
    private fun clickBack(){
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}