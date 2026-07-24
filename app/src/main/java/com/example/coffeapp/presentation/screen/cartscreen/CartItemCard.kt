package com.example.coffeapp.presentation.screen.cartscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeapp.domain.model.Products
import com.example.coffeapp.presentation.theme.LightBrown
import com.example.coffeapp.presentation.theme.LightGray

@Composable
fun CartItemCard(
    products: Products
) {
    var quantity by remember { mutableStateOf(products.quantity ?: 1) }

    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp), colors = CardDefaults.cardColors(
            containerColor = LightGray
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = products.image),
                contentDescription = "",
                modifier = Modifier
                    .size(70.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp),
            ) {
                Text(
                    products.name,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.bodyLarge,

                    )
                Text(
                    products.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.DarkGray
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                IconButton(
                    onClick = {

                        quantity--

                    },
                    enabled = quantity > 1,
                    modifier = Modifier
                        .background(
                            color = LightBrown.copy(0.15f), shape = CircleShape
                        )
                        .size(24.dp),
                ) {
                    Icon(
                        tint = LightBrown,
                        imageVector = Icons.Default.Remove,
                        contentDescription = "decrease"
                    )
                }
                Text(
                    "$quantity",
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold
                )
                IconButton(
                    {
                        quantity++
                    },
                    modifier = Modifier
                        .background(
                            color = LightBrown.copy(0.15f), shape = CircleShape
                        )
                        .size(24.dp),
                ) {
                    Icon(

                        tint = LightBrown,
                        imageVector = Icons.Default.Add,
                        contentDescription = "increase"
                    )
                }

            }
        }
    }


}