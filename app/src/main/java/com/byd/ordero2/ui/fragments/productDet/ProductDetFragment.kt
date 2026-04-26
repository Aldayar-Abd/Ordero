package com.byd.ordero2.ui.fragments.productDet

import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.byd.ordero2.R
import com.byd.ordero2.databinding.FragmentProductDetBinding
import com.byd.ordero2.ui.fragments.mainfragment.products.Product
import com.byd.ordero2.ui.utils.BaseFragment


class ProductDetFragment : BaseFragment<FragmentProductDetBinding>(FragmentProductDetBinding::inflate) {
    private lateinit var  adapter : ProductDetAdapter
    private lateinit var product: Product
    override fun setUpUI() {
        product = arguments?.getSerializable("product") as Product

        setUpRv()
        bindData()
        binding.btnAddToCart.setOnClickListener {
            val bundle = bundleOf("product" to product)

            findNavController().navigate(
                R.id.productChartFragment,
                bundle
            )
        }
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.btnMsg.setOnClickListener {
            findNavController().navigate(R.id.chatFragment)
        }
    }

    private fun setUpRv(){
        adapter = ProductDetAdapter()
        binding.rvColors.adapter = adapter
        binding.rvColors.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

    }
    private fun bindData() {

        when (product) {

            // ================== ОДЕЖДА ==================
            is Product.Clothes -> {

                val item = product as Product.Clothes

                // базовые данные
                binding.imgProduct.setImageResource(item.img)
                binding.txtNameProduct.text = item.name
                binding.txtCount.text = item.count
                binding.txtBooked.text = item.booked
                binding.txtPrice.text = "${item.price} сом"

                // показываем нужное
                binding.sizeContainer.visibility = View.VISIBLE
                binding.rvColors.visibility = View.VISIBLE

                // размеры и цвета
                setupSizes(item.sizes)
                adapter.submitList(item.colors)
            }

            is Product.Sport -> {

                val item = product as Product.Sport

                // базовые данные
                binding.imgProduct.setImageResource(item.img)
                binding.txtNameProduct.text = item.name
                binding.txtCount.text = item.count
                binding.txtBooked.text = item.booked
                binding.txtPrice.text = "${item.price} сом"

                // показываем нужное
                binding.sizeContainer.visibility = View.VISIBLE
                binding.rvColors.visibility = View.VISIBLE

                // размеры и цвета
                setupSizes(item.sizes)
                adapter.submitList(item.colors)
            }

            // ================== МЕДТОВАРЫ ==================
            is Product.Medical -> {

                val item = product as Product.Medical

                binding.imgProduct.setImageResource(item.img)
                binding.txtNameProduct.text = item.name
                binding.txtCount.text = item.count
                binding.txtBooked.text = item.booked
                binding.txtPrice.text = "${item.price} сом"

                binding.sizeContainer.visibility = View.GONE
                binding.rvColors.visibility = View.VISIBLE

                adapter.submitList(item.colors)

            }

            // ================== ДРЕВЕСИНА ==================
            is Product.Wood -> {

                val item = product as Product.Wood

                binding.imgProduct.setImageResource(item.img)
                binding.txtNameProduct.text = item.name
                binding.txtCount.text = item.count
                binding.txtBooked.text = item.booked
                binding.txtPrice.text = "${item.price} сом"

                binding.sizeContainer.visibility = View.GONE
                binding.rvColors.visibility = View.VISIBLE
                binding.txtTitleColor.text = "Материалы: "

                adapter.submitList(item.colors)

            }

            is Product.Accessories -> {

                val item = product as Product.Accessories

                binding.imgProduct.setImageResource(item.img)
                binding.txtNameProduct.text = item.name
                binding.txtCount.text = item.count
                binding.txtBooked.text = item.booked
                binding.txtPrice.text = "${item.price} сом"

                binding.sizeContainer.visibility = View.GONE
                binding.rvColors.visibility = View.VISIBLE
                binding.txtTitleColor.text = "Материалы: "

                adapter.submitList(item.material)

            }
        }
    }

    private fun setupSizes(sizes: List<String>) {
        binding.itemXss.visibility = if ("XXS" in sizes) View.VISIBLE else View.GONE
        binding.itemXs.visibility = if ("XS" in sizes) View.VISIBLE else View.GONE
        binding.itemS.visibility = if ("S" in sizes) View.VISIBLE else View.GONE
        binding.itemM.visibility = if ("M" in sizes) View.VISIBLE else View.GONE
        binding.itemL.visibility = if ("L" in sizes) View.VISIBLE else View.GONE
        binding.itemXl.visibility = if ("XL" in sizes) View.VISIBLE else View.GONE
        binding.item2xl.visibility = if ("2XL" in sizes) View.VISIBLE else View.GONE
        binding.item3xl.visibility = if ("3XL" in sizes) View.VISIBLE else View.GONE
        binding.item4xl.visibility = if ("4XL" in sizes) View.VISIBLE else View.GONE
        binding.item5xl.visibility = if ("5XL" in sizes) View.VISIBLE else View.GONE
    }

}