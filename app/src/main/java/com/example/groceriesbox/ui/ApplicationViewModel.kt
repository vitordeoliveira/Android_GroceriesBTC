package com.example.groceriesbox.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.groceriesbox.data.Cart
import com.example.groceriesbox.data.CartRepository
import com.example.groceriesbox.data.FakeCartRepository
import com.example.groceriesbox.data.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class ApplicationUiState(
    val cart: Cart = Cart()
)

class ApplicationViewModel(private val cartRepository: CartRepository):ViewModel(){
    private val _uiState = MutableStateFlow(ApplicationUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.update { current ->
                current.copy(cart = cartRepository.getCart())
            }
        }
    }

//    val uiState = MutableStateFlow(cartRepository).filterNotNull()
//        .map { ApplicationUiState(it.getCart().items) }
//        .stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(5_000),
//            initialValue = ApplicationUiState()
//        )


}

