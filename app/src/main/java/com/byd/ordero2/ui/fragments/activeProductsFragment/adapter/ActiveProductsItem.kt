package com.byd.ordero2.ui.fragments.activeProductsFragment.adapter

data class ActiveProductsItem(
    val id: Int,
    var nameProduct: String,
    var nameShop: String,
    var price: String,
    var imageProduct: Int,
    var imageProfile: Int,
    var isFavorite: Boolean
)