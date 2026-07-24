package com.example.coffeapp.presentation.screen.profilescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coffeapp.presentation.navigation.Routes
import com.example.coffeapp.presentation.theme.LightBrown
import com.example.coffeapp.presentation.theme.LightGray
import com.example.coffeapp.presentation.ui_components.MyBottomNAVBar

@Composable
fun ProfileScreen(navController: NavController) {

    Scaffold(
        topBar = { ProfileTopAppBar() },
        bottomBar = { MyBottomNAVBar(navController, Routes.ProfileScreen) }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .background(color = LightBrown.copy(0.15f), shape = CircleShape)
                    .size(140.dp), contentAlignment = Alignment.Center

            ) {
                Icon(
                    modifier = Modifier.size(80.dp),
                    imageVector = Icons.Default.Person,
                    tint = LightBrown,
                    contentDescription = "Welcome Image"
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "M Hammad Baloch", style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(text = "hammadb193@gmail.com")

            Spacer(modifier = Modifier.height(100.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = "Address", style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Safia Clinic")
                Text(text = "Mda Road")
                Text(text = "Multan")


            }




            Spacer(modifier = Modifier.height(100.dp))

            Card(
                modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(
                    containerColor = LightGray.copy(0.5f)
                )
            ) {
                Column(modifier = Modifier.padding(30.dp)) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier.size(30.dp),
                            imageVector = Icons.Default.ShoppingCart,
                            tint = LightBrown,
                            contentDescription = "Order Car"
                        )

                        Text(
                            text = "Orders", style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier.size(30.dp),
                            imageVector = Icons.Default.Favorite,
                            tint = LightBrown,
                            contentDescription = "Order Car"
                        )

                        Text(
                            text = "Favorites", style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                    }
                }


            }


        }
    }
}