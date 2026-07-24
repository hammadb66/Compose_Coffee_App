package com.example.coffeapp.presentation.screen.detailsscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeapp.presentation.theme.CharcoalGray
import com.example.coffeapp.presentation.theme.LightBrown


@Composable
fun SelectSizeChip(size: String, selected: Boolean, onclick: () -> Unit, modifier: Modifier) {

    Box(
        modifier = modifier
            .clickable {
                onclick()
            }
            .background(color = if (selected) Color(0xFff7f0eb) else Color(0xFffdfdfd))
            .border(
                width = 1.dp,
                if (selected) Color(0xFfc67c4e) else Color(0xFfe1e1e1),
                shape = RoundedCornerShape(12.dp)
            ), contentAlignment = Alignment.Center) {
        Text(
            text = size,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = if (selected) LightBrown else CharcoalGray
        )
    }

}