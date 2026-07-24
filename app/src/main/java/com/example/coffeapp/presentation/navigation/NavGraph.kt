package com.example.coffeapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.coffeapp.presentation.screen.cartscreen.CartScreen
import com.example.coffeapp.presentation.screen.detailsscreen.DetailsScreen
import com.example.coffeapp.presentation.screen.favoritescreen.FavoriteScreen
import com.example.coffeapp.presentation.screen.homescreen.HomeScreen
import com.example.coffeapp.presentation.screen.profilescreen.ProfileScreen
import com.example.coffeapp.presentation.screen.welcomescreen.WelcomeScreen

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    // Professional Tip: Start destination ko control karne ke liye logic
    NavHost(
        navController = navController,
        startDestination = Routes.WelcomeScreen,
    ) {
        composable<Routes.WelcomeScreen> {
            WelcomeScreen(navController)
        }
        composable<Routes.ProfileScreen> {
            ProfileScreen(navController)
        }
        composable<Routes.FavoriteScreen> {
            FavoriteScreen(navController)
        }

        composable<Routes.HomeScreen> {
            HomeScreen(navController)
        }

        composable<Routes.CartScreen> {
            CartScreen(navController)
        }

        composable<Routes.DetailsScreen> { backStackEntry ->
            val args = backStackEntry.toRoute<Routes.DetailsScreen>()
            DetailsScreen(args.productId, navController)
        }
    }
}
