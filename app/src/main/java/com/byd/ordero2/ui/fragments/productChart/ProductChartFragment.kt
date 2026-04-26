package com.byd.ordero2.ui.fragments.productChart

import android.graphics.Color
import android.view.View
import android.widget.EditText
import android.widget.GridLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.byd.ordero2.R
import com.byd.ordero2.databinding.FragmentProductChartBinding
import com.byd.ordero2.ui.fragments.mainfragment.products.Product
import com.byd.ordero2.ui.fragments.mainfragment.products.ProductType
import com.byd.ordero2.ui.fragments.productDet.ProductDetAdapter
import com.byd.ordero2.ui.fragments.productDet.ProductDetItem
import com.byd.ordero2.ui.utils.BaseFragment
import com.google.android.material.card.MaterialCardView


class ProductChartFragment : BaseFragment<FragmentProductChartBinding>(FragmentProductChartBinding::inflate) {


    private lateinit var rvSelectAdapter: PCAdapter
    private lateinit var rvColorsAdapter: ProductDetAdapter
    private lateinit var product: Product

    private val selectedSizes = mutableSetOf<String>()
    private val selectedColors = mutableSetOf<ProductDetItem>()

    override fun setUpUI() {

        // ✅ 1. Получаем товар
        product = arguments?.getSerializable("product") as Product

        setupAdapters()
        setupData()
        setupSizeClicks()

        binding.btnConfirm.setOnClickListener {
            findNavController().navigate(R.id.chartFragment)
        }

        when (product) {

            is Product.Clothes -> {
                binding.txtColors.text = "Выберите расцветки:"
            }
            is Product.Sport -> {
                binding.txtColors.text = "Выберите расцветки:"
            }
            is Product.Accessories -> {
                binding.txtColors.text = "Выберите материал:"
            }


            is Product.Medical -> {
                binding.txtColors.text = "Выберите расцветки:"
            }

            is Product.Wood -> {
                binding.txtColors.text = "Выберите материал:"
            }
        }

    }

    private fun setupAdapters() {

        rvSelectAdapter = PCAdapter { item, position ->
            openCountBottomSheet(item, position)
        }
        binding.rvSelectCount.adapter = rvSelectAdapter
        binding.rvSelectCount.layoutManager =
            LinearLayoutManager(requireContext())

        rvColorsAdapter = ProductDetAdapter(true) { color ->
            onColorClick(color)
        }

        binding.rvColors.adapter = rvColorsAdapter
        binding.rvColors.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }

    private fun openCountBottomSheet(item: ChoosedItem, position: Int) {

        val editText = EditText(requireContext()).apply {
            inputType = android.text.InputType.TYPE_CLASS_NUMBER
            setText(item.selectedCount.filter { it.isDigit() })

            setPadding(32, 24, 32, 24)
        }

        AlertDialog.Builder(requireContext())
            .setTitle("Введите количество")
            .setView(editText)
            .setPositiveButton("OK") { _, _ ->

                val value = editText.text.toString().toIntOrNull() ?: 0

                updateItemCount(item,   value, position)
            }
            .setNegativeButton("Отмена", null)
            .show()
    }

    private fun updateItemCount(item: ChoosedItem, count: Int, pos: Int) {

        val list = rvSelectAdapter.currentList.toMutableList()

        val index = list.indexOfFirst { it.id == item.id }
        if (index == -1) return

        list[index] = list[index].copy(
            selectedCount = "$count шт"
        )

        rvSelectAdapter.submitList(list.toList())
    }


    private fun setupData() {

        when (product) {

            is Product.Clothes -> {
                val item = product as Product.Clothes

                // показываем цвета
                rvColorsAdapter.submitList(item.colors)

                // показываем размеры
                setupSizes(item.sizes)
            }

            is Product.Sport -> {
                val item = product as Product.Sport

                // показываем цвета
                rvColorsAdapter.submitList(item.colors)

                // показываем размеры
                setupSizes(item.sizes)
            }

            is Product.Medical -> {
                val item = product as Product.Medical

                // показываем цвета
                rvColorsAdapter.submitList(item.colors)
                binding.sizeCont.visibility = View.GONE

            }

            is Product.Wood -> {
                val item = product as Product.Wood

                // показываем цвета
                rvColorsAdapter.submitList(item.colors)
                binding.sizeCont.visibility = View.GONE
            }
            is Product.Accessories -> {
                val item = product as Product.Accessories

                // показываем цвета
                rvColorsAdapter.submitList(item.material)
                binding.sizeCont.visibility = View.GONE
            }

            else -> {
                binding.sizeCont.visibility = View.GONE
                binding.rvColors.visibility = View.GONE
            }
        }
    }

    private fun setupSizes(sizes: List<String>) {

        val grid = binding.sizeCont.getChildAt(1) as GridLayout

        for (i in 0 until grid.childCount) {

            val card = grid.getChildAt(i) as CardView
            val text = card.getChildAt(0) as TextView
            val size = text.text.toString()

            card.visibility = if (sizes.contains(size)) View.VISIBLE else View.GONE
        }
    }

    private fun setupSizeClicks() {

        val grid = binding.sizeCont.getChildAt(1) as GridLayout

        for (i in 0 until grid.childCount) {

            val card = grid.getChildAt(i) as MaterialCardView
            val text = card.getChildAt(0) as TextView
            val size = text.text.toString()

            card.setOnClickListener {

                if (selectedSizes.contains(size)) {
                    selectedSizes.remove(size)
                    unselectCard(card)
                } else {
                    selectedSizes.add(size)
                    selectCard(card)
                }

                generateVariants()
            }
        }
    }

    private fun onColorClick(color: ProductDetItem) {

        if (selectedColors.contains(color)) {
            selectedColors.remove(color)
        } else {
            selectedColors.add(color)
        }

        generateVariants()
    }

    private fun generateVariants() {

        val result = mutableListOf<ChoosedItem>()

        when (val item = product) {

            // ================== ОДЕЖДА ==================
            is Product.Clothes -> {

                for (variant in item.variant) {

                    val color = item.colors.find { it.id == variant.colorId } ?: continue

                    val sizeMatch =
                        selectedSizes.isEmpty() || selectedSizes.contains(variant.size)

                    val colorMatch =
                        selectedColors.isEmpty() || selectedColors.any { it.id == variant.colorId }

                    if (sizeMatch && colorMatch) {
                        result.add(
                            ChoosedItem(
                                id = "${variant.colorId}_${variant.size}",
                                size = variant.size,
                                color = color.color,
                                availableCount = "${variant.stock} шт",
                                selectedCount = "",
                                img = color.img,
                                type = ProductType.CLOTHES
                            )
                        )
                    }
                }
            }

            is Product.Sport -> {

                for (variant in item.variant) {

                    val color = item.colors.find { it.id == variant.colorId } ?: continue

                    val sizeMatch =
                        selectedSizes.isEmpty() || selectedSizes.contains(variant.size)

                    val colorMatch =
                        selectedColors.isEmpty() || selectedColors.any { it.id == variant.colorId }

                    if (sizeMatch && colorMatch) {
                        result.add(
                            ChoosedItem(
                                id = "${variant.colorId}_${variant.size}",
                                size = variant.size,
                                color = color.color,
                                availableCount = "${variant.stock} шт",
                                selectedCount = "",
                                img = color.img,
                                type = ProductType.SPORT
                            )
                        )
                    }
                }
            }

            // ================== МЕДТОВАРЫ ==================
            is Product.Medical -> {

                for (variant in item.variant) {

                    val color = item.colors.find { it.id == variant.colorId } ?: continue

                    val colorMatch =
                        selectedColors.isEmpty() || selectedColors.any { it.id == variant.colorId }



                    if (colorMatch) {
                        result.add(
                            ChoosedItem(
                                id = "${variant.colorId}_${variant.size}",
                                size = variant.size, // 👈 вместо size
                                color = color.color,
                                availableCount = "${variant.stock} шт",
                                selectedCount = "",
                                img = color.img,
                                type = ProductType.MEDICAL

                            )
                        )
                    }
                }
            }

            // ================== ДРЕВЕСИНА ==================
            is Product.Wood -> {
                binding.txtColors.text = "Выберите материал: "
                for (variant in item.variant) {

                    val color = item.colors.find { it.id == variant.colorId } ?: continue

                    val colorMatch =
                        selectedColors.isEmpty() || selectedColors.any { it.id == variant.colorId }



                    if (colorMatch) {
                        result.add(
                            ChoosedItem(
                                id = "${variant.colorId}_${variant.size}",
                                size = variant.size, // 👈 толщина вместо размера
                                color = color.color,
                                availableCount = "${variant.stock} шт",
                                selectedCount = "",
                                img = color.img,
                                type = ProductType.WOOD
                            )
                        )
                    }
                }
            }

            is Product.Accessories -> {
                binding.txtColors.text = "Выберите материал: "
                for (variant in item.variant) {

                    val color = item.material.find { it.id == variant.colorId } ?: continue

                    val colorMatch =
                        selectedColors.isEmpty() || selectedColors.any { it.id == variant.colorId }



                    if (colorMatch) {
                        result.add(
                            ChoosedItem(
                                id = "${variant.colorId}_${variant.size}",
                                size = variant.size, // 👈 толщина вместо размера
                                color = color.color,
                                availableCount = "${variant.stock} шт",
                                selectedCount = "",
                                img = color.img,
                                type = ProductType.ACCESSORIES
                            )
                        )
                    }
                }
            }
        }

        rvSelectAdapter.submitList(result)
    }

    private fun selectCard(card: MaterialCardView) {
        card.strokeWidth = 4
        card.strokeColor = Color.parseColor("#2F80ED")
    }

    private fun unselectCard(card: MaterialCardView) {
        card.strokeWidth = 1
        card.strokeColor = Color.parseColor("#E0E0E0")
    }

//    private lateinit var rvSelectAdapter: PCAdapter
//    private lateinit var rvColorsAdapter: ProductDetAdapter
//    override fun setUpUI() {
//
//        binding.btnConfirm.setOnClickListener {
//            findNavController().navigate(R.id.mainFragment)
//        }
//        rvSelectAdapter = PCAdapter()
//        binding.rvSelectCount.adapter = rvSelectAdapter
//        binding.rvSelectCount.layoutManager =
//            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
//        rvColorsAdapter = ProductDetAdapter()
//        binding.rvColors.adapter = rvColorsAdapter
//        binding.rvColors.layoutManager =
//            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//
//        setUpItemsCount()
//        setUpItemsColors()
//
//    }
//    private fun setUpItemsCount() {
//        val items = listOf(
//            ChoosedItem(
//                id = 1,
//                size = "M",
//                color = "Красный",
//                availableCount = "220 шт",
//                selectedCount = "50 шт",
//                img = R.drawable.red_shirt
//            ),
//            ChoosedItem(
//                id = 2,
//                size = "L",
//                color = "Белый",
//                availableCount = "200 шт",
//                selectedCount = "100 шт",
//                img = R.drawable.white_shirt
//            ),
//            ChoosedItem(
//                id = 3,
//                size = "XL",
//                color = "Черный",
//                availableCount = "1500",
//                selectedCount = "1000",
//                img = R.drawable.black_shirt
//            ),
//            ChoosedItem(
//                id = 4,
//                size = "S",
//                color = "Серый",
//                availableCount = "500 шт",
//                selectedCount = "120 шт",
//                img = R.drawable.gray_shirt
//            )
//        )
//
//        rvSelectAdapter.submitList(items)
//    }
//    private fun setUpItemsColors() {
//        val colors = listOf(
//            ProductDetItem(1,R.drawable.red_shirt, "Красный"),
//            ProductDetItem(2,R.drawable.white_shirt, "Белый"),
//            ProductDetItem(3,R.drawable.gray_shirt, "Серый"),
//            ProductDetItem(4,R.drawable.black_shirt, "Черный"),
//            ProductDetItem(5,R.drawable.beige_shirt, "Бежевый"),
//            ProductDetItem(6,R.drawable.khaki_shirt, "Хаки")
//        )
//        rvColorsAdapter.submitList(colors)
//    }

}