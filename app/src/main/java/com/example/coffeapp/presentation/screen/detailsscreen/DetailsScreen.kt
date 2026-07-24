package com.example.coffeapp.presentation.screen.detailsscreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.coffeapp.R
import com.example.coffeapp.domain.model.Products


@Composable
fun DetailsScreen(productId: Int, navController: NavHostController) {

    val allProducts =listOf(
        Products(
            1, "Espresso", "Strong and Rich", 9.4, R.drawable.coffee_1

        ), Products(
            2, "Latte", "Strong and Rich", 6.9, R.drawable.coffee_2

        ), Products(
            3, "Cappuccino", "Strong and Rich", 3.7, R.drawable.coffee_3

        ), Products(
            4, "Mocha", "Strong and Rich", 9.1, R.drawable.coffee_4

        ), Products(
            5, "Macchiato", "Strong and Rich", 3.5, R.drawable.coffee_5

        ), Products(
            6, "Flat White", "Strong and Rich", 6.01, R.drawable.coffee_6

        ), Products(
            7, "Iced Mocha", "Strong and Rich", 1.55, R.drawable.coffee_2

        )

    )

    val products = allProducts.find { it.id == productId }

    if (products == null) {
        Text(text = "Product Not Found", color = Color.Red)
        return
    }

    Scaffold(topBar = {
        DetailScreenTopAppBAr(backClick = { navController.navigateUp() })
    }, bottomBar = { DetailScreenBottomBar(products.price) }

    ) { innerPadding ->
        LazyColumn {
            item {

                    ProductDetailContent(
                        products, innerPadding
                    )
                }
            }
        }



}


