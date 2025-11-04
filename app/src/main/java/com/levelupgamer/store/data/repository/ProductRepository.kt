package com.levelupgamer.store.data.repository

import com.levelupgamer.store.data.model.Product
import com.example.proyectoappmovil.R

class ProductRepository {
    // A list of all products in the store
    private val allProducts = listOf(
        // Tarjetas Gráficas
        Product(1, "NVIDIA RTX 4090", "La GPU para entusiastas definitiva.", 1900000.0, R.drawable.levelupgamer, "Tarjetas Gráficas"),
        Product(2, "AMD RX 7900 XTX", "Rendimiento de gama alta para 4K.", 1100000.0, R.drawable.levelupgamer, "Tarjetas Gráficas"),
        Product(3, "NVIDIA RTX 4070 Ti", "El punto dulce para gaming en 1440p.", 950000.0, R.drawable.levelupgamer, "Tarjetas Gráficas"),

        // Procesadores
        Product(10, "Intel Core i9-13900K", "Potencia bruta para gaming y creación.", 650000.0, R.drawable.levelupgamer, "Procesadores"),
        Product(11, "AMD Ryzen 9 7950X", "El rey de los núcleos para productividad.", 720000.0, R.drawable.levelupgamer, "Procesadores"),
        Product(12, "Intel Core i5-13600K", "El mejor procesador en relación calidad-precio.", 380000.0, R.drawable.levelupgamer, "Procesadores"),

        // Placas Base
        Product(20, "ASUS ROG Maximus Z790", "Lo mejor para Intel 13th Gen.", 750000.0, R.drawable.levelupgamer, "Placas Base"),
        
        // Memoria RAM
        Product(30, "Corsair Vengeance 32GB", "32GB de RAM DDR5 a 6000MHz.", 180000.0, R.drawable.levelupgamer, "Memoria RAM"),

        // Default products for other categories
        Product(100, "Producto Genérico", "Descripción genérica", 10000.0, R.drawable.levelupgamer, "Almacenamiento"),
        Product(101, "Fuente de Poder Genérica", "Descripción genérica", 80000.0, R.drawable.levelupgamer, "Fuentes de Poder"),
        Product(102, "Gabinete Genérico", "Descripción genérica", 50000.0, R.drawable.levelupgamer, "Gabinetes")
    )

    /**
     * Returns a list of all products, regardless of category.
     */
    fun getAllProducts(): List<Product> {
        return allProducts
    }

    /**
     * Returns a list of products filtered by the given category name.
     */
    fun getProductsByCategory(category: String): List<Product> {
        return allProducts.filter { it.category == category }
    }
}
