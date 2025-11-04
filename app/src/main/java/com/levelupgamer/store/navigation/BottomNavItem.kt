package com.levelupgamer.store.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.proyectoappmovil.R

sealed class BottomNavItem(val route: String, val icon: ImageVector, @StringRes val resourceId: Int) {
    object Home : BottomNavItem("home", Icons.Default.Home, R.string.home)
    object Profile : BottomNavItem("profile", Icons.Default.Person, R.string.profile)
    object Cart : BottomNavItem("cart", Icons.Default.ShoppingCart, R.string.my_cart)
}
