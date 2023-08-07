package com.example.groceriesbox.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.groceriesbox.ui.navigation.NavigationDestination
import com.example.groceriesbox.ui.theme.GroceriesBoxTheme
import kotlinx.coroutines.launch

object HomeScreenDestination : NavigationDestination {
    override val route: String = "HomeScreen"
    override val titleRes: Int
        get() = TODO("Not yet implemented")

}

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navigateTo: () -> Unit = {}) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BoxOption()
        BoxOption()
        BoxOption()
        BoxOption(navigateTo=navigateTo)
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoxOption(modifier: Modifier = Modifier, navigateTo: () -> Unit = {}) {
    ElevatedCard(
        onClick = navigateTo,
        modifier = modifier.size(width = 325.dp, height = 130.dp),
        elevation = CardDefaults.elevatedCardElevation(5.dp)
    ) {
        Box(Modifier.fillMaxSize()) {
            Text("Clickable", Modifier.align(Alignment.Center))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    GroceriesBoxTheme(darkTheme = false) {
        HomeScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreviewDark() {
    GroceriesBoxTheme(darkTheme = true) {
        HomeScreen()
    }
}
