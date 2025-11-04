package com.levelupgamer.store.data.model

import androidx.annotation.DrawableRes

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    @DrawableRes val imageRes: Int,
    val category: String // Added category field
)
