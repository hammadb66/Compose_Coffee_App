package com.example.coffeapp.presentation.screen.cartscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeapp.R
import com.example.coffeapp.presentation.theme.LightBrown

@Composable
fun PaymentModeSelectionCart(totalAmount: Double) {
    var expanded by remember { mutableStateOf(false) }
    val paymentModes = listOf("Online", "Cash")
    var paymentMode by remember { mutableStateOf("Online") }


    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(24.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(if (paymentMode == "Online") R.drawable.mobile_banking else R.drawable.wallet),
                        contentDescription = "Mobile Banking",
                        tint = LightBrown
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(

                    ) {
                        Text(
                            text = paymentMode,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.ExtraBold,
                            ),

                            )

                        Spacer(modifier = Modifier.height(4.dp))


                        Text(
                            text = if (paymentMode == "Online") "$ $totalAmount" else "$ ${totalAmount + 1.0}",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.SemiBold,
                            ),
                            color = LightBrown
                        )
                    }

                }

                Box {
                    Icon(
                        modifier = Modifier
                            .size(20.dp)
                            .clickable(onClick = {
                                expanded = !expanded
                            }),
                        painter = painterResource(if (!expanded) R.drawable.regular_outline_arrow_down else R.drawable.regular_outline_arrow_up),
                        contentDescription = "Icon",
                    )


                    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                        paymentModes.forEach { mode ->
                            DropdownMenuItem(
                                modifier = Modifier
                                    .padding(horizontal = 4.dp)
                                    .background(
                                        color = if (paymentMode == mode) LightBrown.copy(0.15f) else Color.Transparent
                                    ), onClick = {
                                    paymentMode = mode
                                    expanded = false
                                }, text = {
                                    Text(text = mode, style = MaterialTheme.typography.bodyLarge)
                                }, leadingIcon = {
                                    Icon(
                                        modifier = Modifier.size(24.dp),
                                        painter = painterResource(if (mode == "Online") R.drawable.mobile_banking else R.drawable.wallet),
                                        contentDescription = "Payment Picture",
                                        tint = LightBrown
                                    )
                                }


                            )
                        }


                    }


                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightBrown, contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp),
                onClick = {}) {
                Text(text = "Place Order", fontSize = 18.sp)

            }

        }
    }

}