package com.byd.ordero2.ui.fragments.mainfragment

import android.graphics.Color
import android.view.Gravity
import android.widget.FrameLayout
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.byd.ordero2.R
import com.byd.ordero2.databinding.FragmentMainBinding
import com.byd.ordero2.ui.fragments.mainfragment.category.CategoryAdapter
import com.byd.ordero2.ui.fragments.mainfragment.category.CategoryItem
import com.byd.ordero2.ui.fragments.mainfragment.products.Product
import com.byd.ordero2.ui.fragments.mainfragment.products.ProductAdapter
import com.byd.ordero2.ui.fragments.mainfragment.products.ProductItem
import com.byd.ordero2.ui.fragments.productChart.Variant
import com.byd.ordero2.ui.fragments.productDet.ProductDetItem
import com.byd.ordero2.ui.utils.BaseFragment
import com.byd.ordero2.ui.utils.HorizontalSpaceItemDecoration
import com.google.android.material.snackbar.Snackbar

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
    private var filteredProducts = mutableListOf<Product>()
    private var selectedCategory: String? = null

    private val allProducts = listOf(

        Product.Clothes(
            id = 1,
            img = R.drawable.prod,
            price = 350,
            name = "Футболка",
            count = "1000",
            booked = "12",
            nameShop = "Fashion home",
            imgShop = R.drawable.ic_prof1,
            sizes = listOf("XS", "S", "M", "L", "XL", "XXS", "2XL", "3XL"),
            colors = listOf(
                ProductDetItem(1, R.drawable.red_shirt, "Красный"),
                ProductDetItem(2, R.drawable.white_shirt, "Белый"),
                ProductDetItem(3, R.drawable.black_shirt, "Черный"),
                ProductDetItem(4, R.drawable.gray_shirt, "Серый"),
                ProductDetItem(5, R.drawable.beige_shirt, "Бежевый"),
                ProductDetItem(6, R.drawable.khaki_shirt, "Хаки"),
            ),
            variant = listOf(
                Variant("XL", 1, 200),
                Variant("XL", 2, 500),
                Variant("M", 6, 300),
                Variant("L", 4, 560),
                Variant("S", 5, 200),
                Variant("XS", 1, 900),
            )
        ),
        Product.Clothes(
            id = 1,
            img = R.drawable.prod,
            price = 350,
            name = "Футболка Oversize",
            count = "1500",
            booked = "120",
            nameShop = "Fashion home",
            imgShop = R.drawable.ic_prof1,
            sizes = listOf("XS", "S", "M", "L"),
            colors = listOf(
                ProductDetItem(1, R.drawable.red_shirt, "Красный"),
                ProductDetItem(2, R.drawable.white_shirt, "Белый"),
                ProductDetItem(3, R.drawable.black_shirt, "Черный")
            ),
            variant = listOf(
                Variant("XS", 1, 50),
                Variant("S", 1, 120),
                Variant("M", 2, 200),
                Variant("L", 3, 180),
            )
        ),

        Product.Clothes(
            id = 2,
            img = R.drawable.prod,
            price = 520,
            name = "Худи Street",
            count = "900",
            booked = "80",
            nameShop = "Urban wear",
            imgShop = R.drawable.ic_prof1,
            sizes = listOf("S", "M", "L"),
            colors = listOf(
                ProductDetItem(1, R.drawable.black_shirt, "Черный"),
                ProductDetItem(2, R.drawable.white_shirt, "Белый")
            ),
            variant = listOf(
                Variant("S", 1, 40),
                Variant("M", 1, 70),
                Variant("L", 2, 100),
            )
        ),

        Product.Clothes(
            id = 3,
            img = R.drawable.prod,
            price = 270,
            name = "Лонгслив Basic",
            count = "2000",
            booked = "300",
            nameShop = "Basic store",
            imgShop = R.drawable.ic_prof1,
            sizes = listOf("XS", "S", "M", "L"),
            colors = listOf(
                ProductDetItem(1, R.drawable.gray_shirt, "Серый"),
                ProductDetItem(2, R.drawable.black_shirt, "Черный")
            ),
            variant = listOf(
                Variant("XS", 1, 80),
                Variant("S", 2, 150),
                Variant("M", 1, 220),
                Variant("L", 2, 110)
            )
        ),

        Product.Clothes(
            id = 4,
            img = R.drawable.prod,
            price = 890,
            name = "Куртка Winter",
            count = "500",
            booked = "50",
            nameShop = "Winter shop",
            imgShop = R.drawable.ic_prof1,
            sizes = listOf("S","M", "L"),
            colors = listOf(
                ProductDetItem(1, R.drawable.black_shirt, "Черный"),
                ProductDetItem(2, R.drawable.white_shirt, "Белый"),
                ProductDetItem(3, R.drawable.red_shirt, "Красный")
            ),
            variant = listOf(
                Variant("M", 1, 30),
                Variant("L", 2, 70),
                Variant("S", 3, 20)
            )
        ),

        Product.Clothes(
            id = 5,
            img = R.drawable.prod,
            price = 420,
            name = "Рубашка Classic",
            count = "1200",
            booked = "150",
            nameShop = "Classic wear",
            imgShop = R.drawable.ic_prof1,
            sizes = listOf("S", "M", "L"),
            colors = listOf(
                ProductDetItem(1, R.drawable.white_shirt, "Белый"),
                ProductDetItem(2, R.drawable.black_shirt, "Черный"),
                ProductDetItem(3, R.drawable.gray_shirt, "Серый")
            ),
            variant = listOf(
                Variant("S", 1, 60),
                Variant("M", 2, 140),
                Variant("L", 3, 90),
            )
        ),

        Product.Medical(
            id = 2,
            img = R.drawable.img_prod2,
            price = 280,
            name = "Маска",
            count = "7000",
            booked = "10",
            nameShop = "Med shop",
            imgShop = R.drawable.ic_prof1,
            colors = listOf(
                ProductDetItem(1, R.drawable.black_shirt, "Черный"),
                ProductDetItem(2, R.drawable.white_shirt, "Белый")
            ),
            material = listOf("Марлевая"),
            variant = listOf(
                Variant("XL", 1, 200)
            )
        ),
        Product.Medical(
            id = 6,
            img = R.drawable.img_prod2,
            price = 120,
            name = "Медицинская маска",
            count = "10000",
            booked = "500",
            nameShop = "Med shop",
            imgShop = R.drawable.ic_prof1,
            colors = listOf(
                ProductDetItem(1, R.drawable.white_shirt, "Одноразовая"),
                ProductDetItem(2, R.drawable.black_shirt, "Многоразовая")
            ),
            material = listOf("Нетканый материал", "Хлопок"),
            variant = listOf(
                Variant("STD", 1, 5000),
                Variant("STD", 2, 3000)
            )
        ),

        Product.Medical(
            id = 7,
            img = R.drawable.img_prod2,
            price = 300,
            name = "Перчатки латексные",
            count = "8000",
            booked = "200",
            nameShop = "MedPro",
            imgShop = R.drawable.ic_prof1,
            colors = listOf(
                ProductDetItem(1, R.drawable.white_shirt, "Латекс"),
                ProductDetItem(2, R.drawable.black_shirt, "Нитрил")
            ),
            material = listOf("Латекс", "Нитрил"),
            variant = listOf(
                Variant("STD", 1, 4000),
                Variant("STD", 2, 3000)
            )
        ),

        Product.Medical(
            id = 8,
            img = R.drawable.img_prod2,
            price = 1500,
            name = "Тонометр",
            count = "2000",
            booked = "100",
            nameShop = "Health store",
            imgShop = R.drawable.ic_prof1,
            colors = listOf(
                ProductDetItem(1, R.drawable.black_shirt, "Автомат"),
                ProductDetItem(2, R.drawable.white_shirt, "Механический")
            ),
            material = listOf("Пластик"),
            variant = listOf(
                Variant("STD", 1, 800),
                Variant("STD", 2, 600)
            )
        ),

        Product.Medical(
            id = 9,
            img = R.drawable.img_prod2,
            price = 600,
            name = "Шприцы",
            count = "15000",
            booked = "2000",
            nameShop = "Med supply",
            imgShop = R.drawable.ic_prof1,
            colors = listOf(
                ProductDetItem(1, R.drawable.white_shirt, "2ml"),
                ProductDetItem(2, R.drawable.white_shirt, "5ml")
            ),
            material = listOf("Пластик"),
            variant = listOf(
                Variant("STD", 1, 9000),
                Variant("STD", 2, 6000)
            )
        ),

        Product.Medical(
            id = 10,
            img = R.drawable.img_prod2,
            price = 250,
            name = "Бинты",
            count = "5000",
            booked = "300",
            nameShop = "Med shop",
            imgShop = R.drawable.ic_prof1,
            colors = listOf(
                ProductDetItem(1, R.drawable.white_shirt, "5см"),
                ProductDetItem(2, R.drawable.white_shirt, "10см")
            ),
            material = listOf("Марля"),
            variant = listOf(
                Variant("STD", 1, 3000),
                Variant("STD", 2, 2000)
            )
        ),
        Product.Wood(
            id = 11,
            img = R.drawable.prod,
            price = 5000,
            name = "Доска строительная",
            count = "1000",
            booked = "120",
            nameShop = "Wood market",
            imgShop = R.drawable.ic_prof1,
            colors = listOf(
                ProductDetItem(1, R.drawable.black_shirt, "Ель"),
                ProductDetItem(2, R.drawable.black_shirt, "Сосна"),
                ProductDetItem(3, R.drawable.black_shirt, "Дуб")
            ),
            variant = listOf(
                Variant("2m", 1, 300),
                Variant("3m", 2, 400),
                Variant("4m", 3, 300)
            )
        ),

        Product.Wood(
            id = 12,
            img = R.drawable.prod,
            price = 8000,
            name = "Фанера",
            count = "600",
            booked = "50",
            nameShop = "Build store",
            imgShop = R.drawable.ic_prof1,
            colors = listOf(
                ProductDetItem(1, R.drawable.black_shirt, "Береза"),
                ProductDetItem(2, R.drawable.black_shirt, "Сосна")
            ),
            variant = listOf(
                Variant("10mm", 1, 200),
                Variant("15mm", 2, 400)
            )
        ),

        Product.Wood(
            id = 13,
            img = R.drawable.prod,
            price = 12000,
            name = "Брус",
            count = "400",
            booked = "60",
            nameShop = "Wood pro",
            imgShop = R.drawable.ic_prof1,
            colors = listOf(
                ProductDetItem(1, R.drawable.black_shirt, "Дуб"),
                ProductDetItem(2, R.drawable.black_shirt, "Ель")
            ),
            variant = listOf(
                Variant("100x100", 1, 150),
                Variant("150x150", 2, 250)
            )
        ),

        Product.Wood(
            id = 14,
            img = R.drawable.prod,
            price = 3000,
            name = "ДСП плита",
            count = "900",
            booked = "80",
            nameShop = "Build market",
            imgShop = R.drawable.ic_prof1,
            colors = listOf(
                ProductDetItem(1, R.drawable.black_shirt, "ЛДСП"),
                ProductDetItem(2, R.drawable.black_shirt, "МДФ")
            ),
            variant = listOf(
                Variant("8mm", 1, 500),
                Variant("12mm", 2, 400)
            )
        ),

        Product.Wood(
            id = 15,
            img = R.drawable.prod,
            price = 7000,
            name = "Ламинат",
            count = "1200",
            booked = "200",
            nameShop = "Floor shop",
            imgShop = R.drawable.ic_prof1,
            colors = listOf(
                ProductDetItem(1, R.drawable.black_shirt, "Дуб светлый"),
                ProductDetItem(2, R.drawable.black_shirt, "Орех")
            ),
            variant = listOf(
                Variant("8mm", 1, 600),
                Variant("10mm", 2, 600)
            )
        ),
        Product.Sport(
            id = 1,
            img = R.drawable.ic_prof1,
            price = 1200,
            name = "Спортивная футболка",
            count = "1500",
            booked = "120",
            nameShop = "SportLine",
            imgShop = R.drawable.ic_prof1,
            sizes = listOf("S", "M", "L"),
            colors = listOf(
                ProductDetItem(1, R.drawable.red_shirt, "Красный"),
                ProductDetItem(2, R.drawable.white_shirt, "Белый"),
                ProductDetItem(3, R.drawable.black_shirt, "Черный")
            ),
            variant = listOf(
                Variant("S", 1, 120),
                Variant("M", 1, 200),
                Variant("L", 2, 180)
            )
        ),

        Product.Sport(
            id = 2,
            img = R.drawable.ic_prof1,
            price = 2500,
            name = "Беговые кроссовки",
            count = "800",
            booked = "50",
            nameShop = "RunnerPro",
            imgShop = R.drawable.ic_prof1,
            sizes = listOf("S", "M", "L"),
            colors = listOf(
                ProductDetItem(1, R.drawable.black_shirt, "Черный"),
                ProductDetItem(2, R.drawable.white_shirt, "Белый")
            ),
            variant = listOf(
                Variant("S", 1, 60),
                Variant("M", 1, 70),
                Variant("L", 2, 40)
            )
        ),

        Product.Sport(
            id = 3,
            img = R.drawable.ic_prof1,
            price = 900,
            name = "Шорты спортивные",
            count = "2000",
            booked = "300",
            nameShop = "ActiveWear",
            imgShop = R.drawable.ic_prof1,
            sizes = listOf("XL", "2XL", "3XL"),
            colors = listOf(
                ProductDetItem(1, R.drawable.black_shirt, "Серый"),
                ProductDetItem(2, R.drawable.white_shirt, "Синий")
            ),
            variant = listOf(
                Variant("3Xl", 1, 120),
                Variant("2XL", 2, 200),
                Variant("XL", 2, 180)
            )
        ),

        Product.Sport(
            id = 4,
            img = R.drawable.ic_prof1,
            price = 3200,
            name = "Футбольная форма",
            count = "500",
            booked = "40",
            nameShop = "ProFootball",
            imgShop = R.drawable.ic_prof1,
            sizes = listOf("XXS", "XS","S", "M", "L", "XL"),
            colors = listOf(
                ProductDetItem(1, R.drawable.red_shirt, "Красный"),
                ProductDetItem(2, R.drawable.white_shirt, "Белый"),
                ProductDetItem(3, R.drawable.black_shirt, "Черный")
            ),
            variant = listOf(
                Variant("M", 1, 30),
                Variant("L", 2, 50),
                Variant("XL", 3, 40),
                Variant("XSS", 2, 40),
                Variant("XS", 2, 40),
                Variant("s", 1, 40),
            )
        ),

        Product.Sport(
            id = 5,
            img = R.drawable.ic_prof1,
            price = 1800,
            name = "Спортивный костюм",
            count = "1100",
            booked = "90",
            nameShop = "UrbanSport",
            imgShop = R.drawable.ic_prof1,
            sizes = listOf("S", "M", "L"),
            colors = listOf(
                ProductDetItem(1, R.drawable.black_shirt, "Черный"),
                ProductDetItem(2, R.drawable.white_shirt, "Серый")
            ),
            variant = listOf(
                Variant("S", 1, 100),
                Variant("M", 1, 200),
                Variant("L", 2, 180)
            )
        ),

        Product.Sport(
            id = 6,
            img = R.drawable.ic_prof1,
            price = 4000,
            name = "Футбольные бутсы",
            count = "600",
            booked = "20",
            nameShop = "ProGear",
            imgShop = R.drawable.ic_prof1,
            sizes = listOf("S", "M", "L"),
            colors = listOf(
                ProductDetItem(1, R.drawable.black_shirt, "Черный"),
                ProductDetItem(2, R.drawable.white_shirt, "Красный")
            ),
            variant = listOf(
                Variant("S", 1, 40),
                Variant("M", 1, 60),
                Variant("L", 2, 80)
            )
        ),

        Product.Sport(
            id = 7,
            img = R.drawable.ic_prof1,
            price = 1500,
            name = "Толстовка",
            count = "1300",
            booked = "110",
            nameShop = "StreetSport",
            imgShop = R.drawable.ic_prof1,
            sizes = listOf("S", "M", "L"),
            colors = listOf(
                ProductDetItem(1, R.drawable.black_shirt, "Черный"),
                ProductDetItem(2, R.drawable.white_shirt, "Синий"),
                ProductDetItem(3, R.drawable.white_shirt, "Белый")
            ),
            variant = listOf(
                Variant("S", 1, 100),
                Variant("M", 2, 150),
                Variant("L", 3, 200),
                Variant("L", 1, 200),
            )
        ),
        Product.Accessories(
            id = 101,
            img = R.drawable.ic_prof1,
            price = 800,
            name = "Солнцезащитные очки",
            count = "3000",
            booked = "200",
            nameShop = "StyleGlass",
            imgShop = R.drawable.ic_prof1,
            material = listOf(
                ProductDetItem(1, R.drawable.black_shirt, "Пластик"),
                ProductDetItem(2, R.drawable.black_shirt, "Металл")
            ),
            variant = listOf(
                Variant("Пластик", 1, 500),
                Variant("Металл", 2, 300)
            )
        ),

        Product.Accessories(
            id = 102,
            img = R.drawable.ic_prof1,
            price = 2500,
            name = "Цепочка",
            count = "1200",
            booked = "80",
            nameShop = "GoldSilver",
            imgShop = R.drawable.ic_prof1,
            material = listOf(
                ProductDetItem(1, R.drawable.black_shirt, "Золото"),
                ProductDetItem(2, R.drawable.black_shirt, "Серебро")
            ),
            variant = listOf(
                Variant("Золото", 1, 120),
                Variant("Серебро", 2, 200)
            )
        ),

        Product.Accessories(
            id = 103,
            img = R.drawable.ic_prof1,
            price = 600,
            name = "Браслет",
            count = "4000",
            booked = "300",
            nameShop = "HandMade",
            imgShop = R.drawable.ic_prof1,
            material = listOf(
                ProductDetItem(1, R.drawable.black_shirt, "Кожа"),
                ProductDetItem(2, R.drawable.black_shirt, "Металл")
            ),
            variant = listOf(
                Variant("Кожа", 1, 600),
                Variant("Металл", 2, 400)
            )
        ),

        Product.Accessories(
            id = 104,
            img = R.drawable.ic_prof1,
            price = 1500,
            name = "Часы",
            count = "900",
            booked = "60",
            nameShop = "TimePro",
            imgShop = R.drawable.ic_prof1,
            material = listOf(
                ProductDetItem(1, R.drawable.black_shirt, "Металл"),
                ProductDetItem(2, R.drawable.black_shirt, "Кожа")
            ),
            variant = listOf(
                Variant("Металл", 1, 300),
                Variant("Кожа", 2, 250)
            )
        ),

        Product.Accessories(
            id = 105,
            img = R.drawable.ic_prof1,
            price = 300,
            name = "Кольцо",
            count = "5000",
            booked = "700",
            nameShop = "RingShop",
            imgShop = R.drawable.ic_prof1,
            material = listOf(
                ProductDetItem(1, R.drawable.black_shirt, "Серебро"),
                ProductDetItem(2, R.drawable.black_shirt, "Золото")
            ),
            variant = listOf(
                Variant("Серебро", 1, 900),
                Variant("Золото", 2, 600)
            )
        ),

        Product.Accessories(
            id = 106,
            img = R.drawable.ic_prof1,
            price = 700,
            name = "Серьги",
            count = "3500",
            booked = "250",
            nameShop = "JewelryPro",
            imgShop = R.drawable.ic_prof1,
            material = listOf(
                ProductDetItem(1, R.drawable.black_shirt, "Серебро"),
                ProductDetItem(2, R.drawable.black_shirt, "Золото"),
                ProductDetItem(3, R.drawable.black_shirt, "Пластик")
            ),
            variant = listOf(
                Variant("Серебро", 1, 500),
                Variant("Золото", 2, 300),
                Variant("Пластик", 3, 200)
            )
        ),

        Product.Accessories(
            id = 107,
            img = R.drawable.ic_prof1,
            price = 1100,
            name = "Пояс",
            count = "2000",
            booked = "150",
            nameShop = "LeatherStyle",
            imgShop = R.drawable.ic_prof1,
            material = listOf(
                ProductDetItem(1, R.drawable.black_shirt, "Кожа"),
                ProductDetItem(2, R.drawable.black_shirt, "Ткань")
            ),
            variant = listOf(
                Variant("Кожа", 1, 700),
                Variant("Ткань", 2, 500)
            )
        )
    )

    private val productAdapter = ProductAdapter { product ->
        val bundle = bundleOf("product" to product)
        findNavController().navigate(R.id.productDetFragment, bundle)
    }

    override fun setUpUI() {
        setUpCategoryRv()
        setUpProductRv()
        setUpSearch()
    }

    // ================== PRODUCTS ==================
    private fun setUpProductRv() {


        filteredProducts = allProducts.toMutableList()

        binding.rvProducts.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvProducts.adapter = productAdapter

        productAdapter.submitList(filteredProducts)
    }

    // ================== CATEGORY ==================
    private fun setUpCategoryRv() {

        val categories = listOf(
            CategoryItem("Все", R.color.purple),
            CategoryItem("Одежда", R.color.purple2),
            CategoryItem("Медтовары", R.color.green),
            CategoryItem("Стройматериалы", R.color.violet),
            CategoryItem("Спорт и хобби", R.color.yellow),
            CategoryItem("Аксессуары", R.color.violet),
        )



        binding.rvCategories.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.rvCategories.adapter = CategoryAdapter(categories) { category ->
            selectedCategory = category.title
            applyFilters()
        }

        binding.rvCategories.addItemDecoration(HorizontalSpaceItemDecoration(10))
    }

    // ================== SEARCH ==================
    private fun setUpSearch() {

        binding.etSearch.addTextChangedListener{
            applyFilters()
        }
    }

    // ================== FILTER LOGIC ==================
    private fun applyFilters() {

        val query = binding.etSearch.text.toString().lowercase()

        filteredProducts = allProducts.filter { product ->

            val matchesSearch = when (product) {
                is Product.Clothes -> product.name.lowercase().contains(query)
                is Product.Medical -> product.name.lowercase().contains(query)
                is Product.Wood -> product.name.lowercase().contains(query)
                is Product.Sport -> product.name.lowercase().contains(query)
                is Product.Accessories -> product.name.lowercase().contains(query)
            }

            val matchesCategory = when (selectedCategory) {
                null, "Все" -> true

                "Одежда" -> product is Product.Clothes
                "Медтовары" -> product is Product.Medical
                "Стройматериалы" -> product is Product.Wood
                "Спорт и хобби" -> product is Product.Sport
                "Аксессуары" -> product is Product.Accessories

                else -> true
            }

            matchesSearch && matchesCategory
        }.toMutableList()

        productAdapter.submitList(filteredProducts)
    }
}
//
//class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
//    override fun setUpUI() {
//        setUpCategoryRv()
//        setUpProductRv()
//
//        binding.btnCamera.setOnClickListener {
////            val snackBar = Snackbar.make(
////                requireActivity().findViewById(android.R.id.content),
////                "+ Новый заказ",
////                Snackbar.LENGTH_SHORT
////            )
////
////            val view = snackBar.view
////            val params = view.layoutParams as FrameLayout.LayoutParams
////            params.gravity = Gravity.TOP
////            view.layoutParams = params
////
////            view.setBackgroundColor(Color.parseColor("#2F80ED"))
////            snackBar.setTextColor(Color.WHITE)
////
////            snackBar.show()
//        }
//
//
//    }
//    private fun setUpCategoryRv(){
//        val categories = listOf(
//            CategoryItem("Техника", R.color.purple),
//            CategoryItem("Одежда", R.color.purple2),
//            CategoryItem("Спорт и хобби", R.color.yellow),
//            CategoryItem("Инструменты", R.color.violet),
//            CategoryItem("Медтовары", R.color.green),
//            CategoryItem("Аксессуары", R.color.violet),
//            CategoryItem("Оборудование для быта", R.color.purple)
//        )
//
//        binding.rvCategories.layoutManager =
//            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//
//        binding.rvCategories.adapter = CategoryAdapter(categories)
//        binding.rvCategories.addItemDecoration(HorizontalSpaceItemDecoration(10))
//    }
//    private fun setUpProductRv() {
//        val products = listOf(
//
//            Product.Clothes(
//                id = 1,
//                img = R.drawable.prod,
//                price = 350,
//                name = "Футболка",
//                count = "1000",
//                booked = "12",
//                nameShop = "Fashion home",
//                imgShop = R.drawable.ic_prof1,
//                sizes = listOf("XS", "XXS", "S", "M", "L", "XL", "2XL", "3XL", "4XL", "5XL"),
//                colors = listOf(
//                    ProductDetItem(1,R.drawable.red_shirt,"Красный"),
//                    ProductDetItem(2,R.drawable.white_shirt,"Белый")
//                ),
//                variant = listOf(
//                    Variant("XL", 1, 200), // красный XL
//                    Variant("XL", 2, 500), // черный XL
//                    Variant("M", 1, 100)
//                )
//            ),
//
//            Product.Clothes(
//                id = 2,
//                img = R.drawable.img_cap,
//                price = 420,
//                name = "Кепка",
//                count = "1200",
//                booked = "123",
//                nameShop = "Street wear",
//                imgShop = R.drawable.ic_prof1,
//                sizes = listOf("M", "L"),
//                colors = listOf(
//                    ProductDetItem(1, R.drawable.black_shirt, "Черный"),
//                    ProductDetItem(2, R.drawable.black_shirt, "Бежевый"),
//                    ProductDetItem(3, R.drawable.black_shirt, "Красный"),
//                ),
//                variant = listOf(
//                    Variant("XL", 1, 200), // красный XL
//                    Variant("XL", 2, 500), // черный XL
//                    Variant("M", 1, 100)
//                )
//            ),
//
//            Product.Medical(
//                id = 3,
//                img = R.drawable.img_prod2,
//                price = 280,
//                name = "Маска",
//                count = "7000",
//                booked = "10",
//                nameShop = "Med shop",
//                imgShop = R.drawable.ic_prof1,
//                colors = listOf(
//                    ProductDetItem(1, R.drawable.black_shirt, "Черный"),
//                    ProductDetItem(2, R.drawable.white_shirt, "Белый"),
//                ),
//                material = listOf("Марлевая", "Марлевая", "Марлевая"),
//                variant = listOf(
//                    Variant("XL", 1, 200), // красный XL
//                    Variant("XL", 2, 500), // черный XL
//                    Variant("M", 1, 100)
//                )
//            ),
//
//            Product.Wood(
//                id = 4,
//                img = R.drawable.prod,
//                price = 2000,
//                name = "Доска",
//                count = "1000",
//                booked = "12",
//                nameShop = "Wood store",
//                imgShop = R.drawable.ic_prof1,
//                colors =listOf (
//                        ProductDetItem(1, R.drawable.black_shirt, "Ель"),
//                        ProductDetItem(2, R.drawable.black_shirt, "Дуб"),
//                        ProductDetItem(3, R.drawable.black_shirt, "Ель"),
//                        ),
//                variant = listOf(
//                    Variant("XL", 1, 200), // красный XL
//                    Variant("XL", 2, 500), // черный XL
//                    Variant("M", 1, 100)
//                )
//            )
//        )
//
//        Product.Clothes(
//            id = 5,
//            img = R.drawable.prod,
//            price = 350,
//            name = "Классические брюки",
//            count = "9000",
//            booked = "200",
//            nameShop = "Fashion home",
//            imgShop = R.drawable.ic_prof1,
//            sizes = listOf("S", "M", "L", "XL"),
//            colors = listOf(
//                ProductDetItem(1,R.drawable.red_shirt,"Черный"),
//                ProductDetItem(2,R.drawable.white_shirt,"Белый"),
//                ProductDetItem(2,R.drawable.white_shirt,"Темно-синий"),
//                ProductDetItem(2,R.drawable.white_shirt,"Серый"),
//            ),
//            variant = listOf(
//                Variant("XL", 1, 200), // красный XL
//                Variant("XL", 2, 500), // черный XL
//                Variant("M", 1, 100)
//            )
//        )
//
//
////        val productAdapter = ProductAdapter{_->
////            findNavController().navigate(R.id.productDetFragment)
////
////        }
//        val productAdapter = ProductAdapter { product ->
//
//            val bundle = bundleOf("product" to product)
//
//            findNavController().navigate(
//                R.id.productDetFragment,
//                bundle
//            )
//        }
//
//        binding.rvProducts.layoutManager = GridLayoutManager(requireContext(), 2)
//        binding.rvProducts.adapter = productAdapter
//
//        productAdapter.submitList(products)
//    }
//
//}