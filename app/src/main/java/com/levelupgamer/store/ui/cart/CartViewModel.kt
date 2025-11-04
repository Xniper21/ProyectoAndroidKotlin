package com.levelupgamer.store.ui.cart

import android.app.Application
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.levelupgamer.store.data.model.Product
import com.levelupgamer.store.data.repository.CartRepository
import com.levelupgamer.store.data.repository.ProductRepository
import com.example.proyectoappmovil.R
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class CartUiState(
    val items: Map<Product, Int> = emptyMap(),
    val total: Double = 0.0
)

class CartViewModel(application: Application) : AndroidViewModel(application) {

    private val productRepository = ProductRepository()
    private val cartRepository = CartRepository()

    val uiState: StateFlow<CartUiState> = cartRepository.getCartItems().map { items ->
        val total = items.entries.sumOf { (product, quantity) -> product.price * quantity }
        CartUiState(items, total)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = CartUiState()
    )

    fun addToCart(productId: Int) {
        viewModelScope.launch {
            productRepository.getAllProducts().find { it.id == productId }?.let {
                cartRepository.addToCart(it)
                sendNotification(it)
            }
        }
    }

    private fun sendNotification(product: Product) {
        val notificationManager = getApplication<Application>().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        
        val notification = NotificationCompat.Builder(getApplication(), "PRODUCT_ADDED_CHANNEL")
            .setSmallIcon(R.drawable.ic_launcher_foreground) // You can use your app's icon
            .setContentTitle("Producto Añadido")
            .setContentText("${product.name} se ha añadido a tu carrito.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(product.id, notification)
    }

    fun removeFromCart(product: Product) {
        viewModelScope.launch {
            cartRepository.removeFromCart(product)
        }
    }

    fun checkout() {
        viewModelScope.launch {
            cartRepository.clearCart()
        }
    }
}
