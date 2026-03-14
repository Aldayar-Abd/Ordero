package com.byd.ordero2.ui.fragments.mainfragment.products

import android.graphics.drawable.Drawable

data class ProductItem (
    val id: Int,
    var img: Int,
    var price: Int,
    var name: String,
    var category: String,
    var favorite: Boolean,
    var nameShop: String,
    var imgShop: Int
)