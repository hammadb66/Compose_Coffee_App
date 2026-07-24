package com.example.coffeapp.presentation.screen.homescreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.coffeapp.domain.model.Products
import com.example.coffeapp.presentation.navigation.Routes


@Composable
fun ProductGrid(products: List<Products>, onClick: (Routes.DetailsScreen) ->  Unit) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(products.chunked(2)) { rowItem ->
            Row(modifier = Modifier.fillMaxWidth()) {
                ProductCard(rowItem[0], modifier = Modifier.weight(1f)) { routs ->
                    onClick(routs)
                }
                if (rowItem.size == 2) {
                    ProductCard(rowItem[1], modifier = Modifier.weight(1f)) { routs ->
                        onClick(routs)
                    }
                } else {
                    Spacer(Modifier.weight(1f))
                }
            }
        }
    }
}