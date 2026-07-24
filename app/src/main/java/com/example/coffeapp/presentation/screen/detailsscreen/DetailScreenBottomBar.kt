package com.example.coffeapp.presentation.screen.detailsscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeapp.presentation.theme.IvoryWhite
import com.example.coffeapp.presentation.theme.LightBrown
import com.example.coffeapp.presentation.ui_components.AppMessageDialog

@Composable
fun DetailScreenBottomBar(price: Double) {
    var showCartDialog by remember { mutableStateOf(false) }

    BottomAppBar(
        containerColor = Color.Transparent, tonalElevation = 0.dp
    ) {
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            Column() {
                Text(text = "Price", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "$${price}", fontSize = 24.sp, fontWeight = FontWeight.SemiBold
                )

            }

            Spacer(modifier = Modifier.width(40.dp))
            Button(
                onClick = {
                    showCartDialog = true

                },
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightBrown, contentColor = IvoryWhite
                )
            ) {
                Text(text = "Add To Cart", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
            }


            AppMessageDialog(
                showCartDialog,
                title = "Success",
                message = "Item added to cart",
                onDismiss = { showCartDialog = false })
        }


    }

}