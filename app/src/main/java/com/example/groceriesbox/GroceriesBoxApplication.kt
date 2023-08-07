package com.example.groceriesbox

import android.app.Application
import com.example.groceriesbox.data.AppContainer
import com.example.groceriesbox.data.AppDataContainer

class GroceriesBoxApplication:Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer()
    }
}