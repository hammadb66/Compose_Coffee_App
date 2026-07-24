package com.example.coffeapp.presentation.screen.detailsscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeapp.R
import com.example.coffeapp.domain.model.Products
import com.example.coffeapp.presentation.theme.IvoryWhite
import com.example.coffeapp.presentation.theme.LightBrown

@Composable
fun ProductDetailContent(products: Products, innerPadding: PaddingValues) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(innerPadding)
    ) {
        Image(
            painter = painterResource(products.image),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = products.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
        )
        Spacer(modifier = Modifier.height(8
            .dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Text(
                text = "Ice/Hot",
                color = Color.Gray,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            Icon(
                modifier = Modifier
                    .background(
                        color = IvoryWhite, shape = RoundedCornerShape(16.dp)
                    )
                    .size(40.dp)
                    .padding(6.dp),
                tint = LightBrown,
                painter = painterResource(R.drawable.default_bean),
                contentDescription = "Icon"
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        HorizontalDivider(thickness = 1.dp, color = Color.LightGray.copy(0.5f))
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Description",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = products.description,
            color = Color.Gray,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Size",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
        )
        Spacer(modifier = Modifier.height(16.dp))
        var selectedSize by remember {
            mutableStateOf("M")
        }
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            listOf("S", "M", "L").forEach { size ->

                SelectSizeChip(
                    size = size,
                    selected = selectedSize == size,
                    onclick = { selectedSize = size },
                    Modifier
                        .weight(1f)
                        .height(46.dp)

                )
            }
        }


    }


}