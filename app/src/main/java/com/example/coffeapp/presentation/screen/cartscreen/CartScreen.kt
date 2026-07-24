package com.example.coffeapp.presentation.screen.cartscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeapp.R
import com.example.coffeapp.domain.model.Products
import com.example.coffeapp.presentation.navigation.Routes
import com.example.coffeapp.presentation.theme.LightBrown
import com.example.coffeapp.presentation.ui_components.MyBottomNAVBar
import kotlin.math.roundToInt

@Composable
fun CartScreen(navController: NavController) {
    val cartProducts = listOf(
        Products(
            1, "Espresso", "Strong and Rich", 9.4, R.drawable.coffee_1, 1

        ), Products(
            2, "Latte", "Strong and Rich", 6.9, R.drawable.coffee_2, 1

        ), Products(
            3, "Cappuccino", "Strong and Rich", 3.7, R.drawable.coffee_3, 1

        )

    )


    var amount by remember { mutableStateOf(cartProducts.sumOf { it.price }) }
    var deliverFee by remember {
        mutableStateOf(((cartProducts.sumOf { it.price } / 12.0) * 100).roundToInt() / 100.0)
    }
    var totalAmount by remember { mutableStateOf(amount + deliverFee) }


    Scaffold(topBar = {
        CartScreenTopAppBAr {
            navController.navigateUp()
        }
    }, bottomBar = {
        MyBottomNAVBar(navController, Routes.CartScreen)
    }

    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .padding(innerPadding)
        ) {
            item {
                Row() {
                    Text(
                        text = "Deliver",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = LightBrown
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))
                cartProducts.forEach { products ->
                    CartItemCard(products)
                }


                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    "Payment Summary", style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                    ), fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Price", fontSize = 18.sp)
                    Text("$ $amount", fontSize = 18.sp)
                }

                Spacer(modifier = Modifier.height(2.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text("Delivery Price", fontSize = 18.sp)
                    Text("$ $deliverFee", fontSize = 18.sp)
                }

                Spacer(modifier = Modifier.height(16.dp))

                PaymentModeSelectionCart(totalAmount)

            }


        }

    }

}