package com.example.groceriesbox.ui.items

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.groceriesbox.data.Cart
import com.example.groceriesbox.data.Item
import com.example.groceriesbox.data.ItemsRepository
import com.example.groceriesbox.ui.ApplicationUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class ItemsUiState(
    val string: String = "String",
    val listItems: List<Item> = emptyList()
)

class ItemsViewModel(private val itemsRepository: ItemsRepository): ViewModel() {
    private val _uiState = MutableStateFlow(ItemsUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.update { current ->
                current.copy(listItems = itemsRepository.getAllItems())
            }
        }
    }

}