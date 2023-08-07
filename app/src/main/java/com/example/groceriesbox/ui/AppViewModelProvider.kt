package com.example.groceriesbox.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.groceriesbox.GroceriesBoxApplication
import com.example.groceriesbox.ui.items.ItemsViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory{
        // Initializer for ApplicationViewModel
        initializer {
            ApplicationViewModel(inventoryApplication().container.cartRepository)
        }

        // Initializer for ItemsViewModel
        initializer {
            ItemsViewModel(inventoryApplication().container.itemsRepository)
        }
    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [InventoryApplication].
 */
fun CreationExtras.inventoryApplication(): GroceriesBoxApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as GroceriesBoxApplication)