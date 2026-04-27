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
                img = R.drawable.prod,
                name = "Футболка",
                color = "Красный",
                selectedCount = "1000 шт",
                isSelected = true,
                imgShop = R.drawable.ic_prof1,
                nameShop = "Fashion home"
            ),
            ChartItem(
                id = 2,
                img = R.drawable.ic_clow,
                name = "Худи Street",
                color = "Черный",
                selectedCount = "900 шт",
                isSelected = true,
                imgShop = R.drawable.ic_prof2,
                nameShop = "Urban wear"
            ),
            ChartItem(
                id = 3,
                img = R.drawable.img_23,
                name = "Лонгслив Basic",
                color = "Серый",
                selectedCount = "2000 шт",
                isSelected = true,
                imgShop = R.drawable.ic_clot1,
                nameShop = "Basic store"
            ),
            ChartItem(
                id = 4,
                img = R.drawable.ic_cl2,
                name = "Куртка Winter",
                color = "Черный",
                selectedCount = "500 шт",
                isSelected = true,
                imgShop = R.drawable.ic_prof_man4,
                nameShop = "Winter shop"
            ),
            ChartItem(
                id = 5,
                img = R.drawable.img_10,
                name = "Беговые кроссовки",
                color = "Белый",
                selectedCount = "800 шт",
                isSelected = true,
                imgShop = R.drawable.ic_sport1,
                nameShop = "RunnerPro"
            )
        )
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