package com.levelupgamer.store

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        val name = "Product Added"
        val descriptionText = "Notifications for when a product is added to the cart"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel("PRODUCT_ADDED_CHANNEL", name, importance).apply {
            description = descriptionText
        }
        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}
