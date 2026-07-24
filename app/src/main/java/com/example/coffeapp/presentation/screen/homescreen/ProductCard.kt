package com.example.coffeapp.presentation.screen.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.coffeapp.R
import com.example.coffeapp.domain.model.Products
import com.example.coffeapp.presentation.navigation.Routes
import com.example.coffeapp.presentation.theme.IvoryWhite
import com.example.coffeapp.presentation.theme.LightBrown
import com.example.coffeapp.presentation.theme.LightGray
import com.example.coffeapp.presentation.theme.Typography

@Composable
fun ProductCard(rowItem: Products, modifier: Modifier = Modifier, onClick: (Routes.DetailsScreen) ->  Unit) {


    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp).clickable(onClick = {
                onClick(Routes.DetailsScreen(rowItem.id))
            }),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
            ) {
                Image(
                    painter = painterResource(rowItem.image),
                    contentDescription = "Product image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(20.dp))
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .background(color = LightGray.copy(0.6f), shape = RoundedCornerShape(12.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.favorite),
                        tint = LightBrown,
                        modifier = Modifier.size(24.dp),
                        contentDescription = "Add To Favorite"
                    )

                }

            }
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = rowItem.name, style = Typography.titleMedium.copy(
                    color = Color.Black, fontWeight = FontWeight.SemiBold
                )
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = rowItem.description,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = Typography.bodySmall.copy(
                    color = Color.Gray, fontWeight = FontWeight.Normal
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Price: $${rowItem.price}", style = Typography.titleMedium.copy(
                        color = LightBrown, fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.weight(1f))


                IconButton(
                    onClick = {}, modifier = Modifier.background(
                        color = LightBrown, shape = RoundedCornerShape(10.dp)
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add to Cart",
                        tint = IvoryWhite
                    )

                }
            }
        }
    }
}