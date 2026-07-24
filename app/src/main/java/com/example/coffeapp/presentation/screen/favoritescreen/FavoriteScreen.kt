package com.example.coffeapp.presentation.screen.favoritescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.coffeapp.R
import com.example.coffeapp.domain.model.Products
import com.example.coffeapp.presentation.navigation.Routes
import com.example.coffeapp.presentation.ui_components.MyBottomNAVBar
import kotlin.collections.remove


@Composable
fun FavoriteScreen(navController: NavHostController) {
    // Professional Way: Use mutableStateListOf for observable lists in Compose
    val cartProducts = remember {
        mutableStateListOf(
            Products(
                1, "Espresso", "Strong and Rich", 9.4, R.drawable.coffee_1, 1
            ), Products(
                2, "Latte", "Strong and Rich", 6.9, R.drawable.coffee_2, 1
            ), Products(
                3, "Cappuccino", "Strong and Rich", 3.7, R.drawable.coffee_3, 1
            )

        )
    }

    fun delete(products: Products) {
        cartProducts.remove(products)
    }

    Scaffold(
        topBar = { FavoriteScreenTopAppBar() },
        bottomBar = { MyBottomNAVBar(navController, Routes.FavoriteScreen) }) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(cartProducts) { products ->
                FavoriteCartItem(products, onDeleteClick = { delete(products) })
            }
        }
    }


}




