package com.example.coffeapp.presentation.ui_components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.coffeapp.R
import com.example.coffeapp.presentation.navigation.Routes
import com.example.coffeapp.presentation.theme.LightBrown

@Composable
fun MyBottomNAVBar(navController: NavController, selectedRoutes: Routes) {

    // BottomNavItems
    val navItems = listOf(
        NavItem("Home", R.drawable.home, Routes.HomeScreen),
        NavItem("Cart", R.drawable.cart, Routes.CartScreen),
        NavItem("Favorites", R.drawable.favorite, Routes.FavoriteScreen),
        NavItem("Profile", R.drawable.profile, Routes.ProfileScreen),
    )

    NavigationBar(
        containerColor = Color(0xFFFFFFFF), modifier = Modifier.height(70.dp)
    ) {
        navItems.forEach { item ->
            val isSelected = selectedRoutes::class == item.routes::class

            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = item.title,
                        modifier = Modifier.size(24.dp)
                    )
                }, label = { Text(text = item.title) }, selected = isSelected, onClick = {
                    // Professional Navigation Logic
                    if (!isSelected) {
                        navController.navigate(item.routes) {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }
                }, alwaysShowLabel = isSelected, colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = LightBrown,
                    selectedTextColor = LightBrown,
                    unselectedIconColor = DarkGray,
                    unselectedTextColor = DarkGray,
                    indicatorColor = LightBrown.copy(0.1f)
                )
            )
        }
    }
}

data class NavItem(
    val title: String, val icon: Int, val routes: Routes
)
