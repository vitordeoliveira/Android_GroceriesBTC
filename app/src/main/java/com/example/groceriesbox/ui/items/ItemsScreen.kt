package com.example.groceriesbox.ui.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.groceriesbox.data.FakeDataSource
import com.example.groceriesbox.data.FakeItemRepository
import com.example.groceriesbox.data.Item
import com.example.groceriesbox.ui.AppViewModelProvider
import com.example.groceriesbox.ui.ApplicationViewModel
import com.example.groceriesbox.ui.navigation.NavigationDestination
import com.example.groceriesbox.ui.theme.GroceriesBoxTheme
import androidx.compose.foundation.lazy.items

object ItemsDestination : NavigationDestination {
    override val route: String = "ItemsDestination"
    override val titleRes: Int
        get() = TODO("Not yet implemented")

}

@Composable
fun ItemsScreen(viewModel: ItemsViewModel = viewModel(factory = AppViewModelProvider.Factory)){
    val state = viewModel.uiState.collectAsState()
    ItemsBody(listItems = state.value.listItems)
}

@Composable
fun ItemsBody(listItems: List<Item>){
    LazyColumn(){
        items(listItems){
            ItemCard(it)
        }
    }
}

@Composable
fun ItemCard(item: Item){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "id: ${item.id}")
        Text(text = item.name)
        Text(text = item.price_in_btc.toString())
        Text(text = item.price_in_eur.toString())
        Text(text = item.price_in_satoshi.toString())
    }
}



@Preview(showBackground = true)
@Composable
fun ItemScreenPreview(
    items:List<Item> = FakeDataSource.listItems
) {
    GroceriesBoxTheme(darkTheme = false) {
        ItemsBody(items)
    }
}

@Preview(showBackground = true)
@Composable
fun ItemScreenPreviewDark(
    items:List<Item> = FakeDataSource.listItems
) {
    GroceriesBoxTheme(darkTheme = true) {
        ItemsBody(items)
    }
}