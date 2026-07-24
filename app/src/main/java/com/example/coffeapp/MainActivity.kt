package com.example.coffeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.coffeapp.presentation.navigation.NavGraph
import com.example.coffeapp.presentation.screen.cartscreen.CartScreen
import com.example.coffeapp.presentation.screen.detailsscreen.DetailsScreen
import com.example.coffeapp.presentation.screen.homescreen.HomeScreen
import com.example.coffeapp.presentation.theme.CoffeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffeAppTheme {
                NavGraph()
            }
        }
    }
}
