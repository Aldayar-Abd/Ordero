package com.byd.ordero2.ui.fragments.productChart

import com.byd.ordero2.ui.fragments.mainfragment.products.ProductType

data class ChoosedItem (
    val id: String,
    var size: String,
    var color: String,
    var availableCount: String,
    var selectedCount: String,
    var img: Int,
    val type: ProductType
)