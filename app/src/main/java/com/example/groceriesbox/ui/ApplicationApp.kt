package com.example.groceriesbox.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.groceriesbox.R
import com.example.groceriesbox.ui.navigation.AppNavGraph
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApplicationApp(
    viewModel: ApplicationViewModel = viewModel(factory = AppViewModelProvider.Factory),
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val items = listOf(Icons.Default.Favorite, Icons.Default.Face, Icons.Default.Email)
    val applicationUiState by viewModel.uiState.collectAsState()


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                applicationUiState.cart.items.forEach{item ->
                    Text(text = item.name)
                }
            }
        },
        content = {
            Scaffold(
                topBar = {
                    BTCBoxAppBar(onClickCart = {
                        scope.launch {
                            drawerState.open()
                        }
                    })
                }
            ) {
                AppNavGraph(modifier = Modifier.padding(it))
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BTCBoxAppBar(
    modifier: Modifier = Modifier,
    onClickCart: () -> Unit,
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                stringResource(id = R.string.app_name),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.headlineSmall
            )
        },
        navigationIcon = {
            IconButton(onClick = { onClickCart() }) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = "Localized description"
                )
            }
        },
        actions = {
            IconButton(onClick = { /* doSomething() */ }, modifier = Modifier.size(35.dp)) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Localized description",
                )
            }
            IconButton(onClick = { /* doSomething() */ }, modifier = Modifier.size(35.dp)) {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Localized description"
                )
            }
            IconButton(onClick = { /* doSomething() */ }, modifier = Modifier.size(35.dp)) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Localized description"
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    )
}