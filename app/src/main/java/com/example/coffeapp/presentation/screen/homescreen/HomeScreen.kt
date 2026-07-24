package com.example.coffeapp.presentation.screen.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.coffeapp.R
import com.example.coffeapp.domain.model.Products
import com.example.coffeapp.presentation.navigation.Routes
import com.example.coffeapp.presentation.ui_components.MyBottomNAVBar

@Composable
fun HomeScreen(navController: NavHostController) {

    Scaffold(
        bottomBar = { MyBottomNAVBar(navController, Routes.HomeScreen) }) { innerPadding ->
        HomeScreenContent(innerPadding, navController)
    }
}

@Composable
fun HomeScreenContent(innerPaddingValues: PaddingValues, navController: NavHostController) {

    val location = "MDA, Multan"

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(1f / 3f)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF303030), Color(0xFF1f1f1f), Color(0xFF121212)
                    )
                )
            )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(innerPaddingValues)
    ) {
        Spacer(modifier = Modifier.height(27.dp))
        Text(text = "Location", color = Color.Gray, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = location, color = Color.White)
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Change Location",
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.height(30.dp))

        MySearchBar()

        Spacer(modifier = Modifier.height(40.dp))

        Image(painter = painterResource(R.drawable.banner_1), contentDescription = "Banner")
        Spacer(modifier = Modifier.height(10.dp))

        HomeScreenCategories()


        val products = listOf(
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

        ProductGrid(products = products) { routes ->
            navController.navigate(routes)
        }
    }

}






















