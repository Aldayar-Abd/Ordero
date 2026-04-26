package com.byd.ordero2.ui.fragments.mainfragment.products

import com.byd.ordero2.ui.fragments.productChart.Variant
import com.byd.ordero2.ui.fragments.productDet.ProductDetItem
import java.io.Serializable

sealed class Product : Serializable {

    data class Clothes(
        val id: Int,
        val img: Int,
        val price: Int,
        val name: String,
        val count: String,
        val booked: String,
        val nameShop: String,
        val imgShop: Int,
        val sizes: List<String>,
        val colors: List<ProductDetItem>,
        val variant: List<Variant>
    ) : Product()

    data class Medical(
        val id: Int,
        val img: Int,
        val price: Int,
        val name: String,
        val count: String,
        val booked: String,
        val nameShop: String,
        val imgShop: Int,
        val colors: List<ProductDetItem>,
        val material: List<String>,
        val variant: List<Variant>

    ) : Product()

    data class Wood(
        val id: Int,
        val img: Int,
        val price: Int,
        val name: String,
        val count: String,
        val booked: String,
        val nameShop: String,
        val imgShop: Int,
        val colors: List<ProductDetItem>,
        val variant: List<Variant>
    ) : Product()

    data class Sport(
        val id: Int,
        val img: Int,
        val price: Int,
        val name: String,
        val count: String,
        val booked: String,
        val nameShop: String,
        val imgShop: Int,
        val sizes: List<String>,
        val colors: List<ProductDetItem>,
        val variant: List<Variant>
    ) : Product()

    data class Accessories(
        val id: Int,
        val img: Int,
        val price: Int,
        val name: String,
        val count: String,
        val booked: String,
        val nameShop: String,
        val imgShop: Int,
        val material: List<ProductDetItem>,
        val variant: List<Variant>
    ) : Product()
}
