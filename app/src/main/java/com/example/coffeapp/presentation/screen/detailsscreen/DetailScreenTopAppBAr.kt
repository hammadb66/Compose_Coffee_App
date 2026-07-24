package com.example.coffeapp.presentation.screen.detailsscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.coffeapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreenTopAppBAr(backClick: () -> Unit) {
    TopAppBar(
        actions = {
            Icon(
                modifier = Modifier.padding(start = 16.dp),
                painter = painterResource(R.drawable.favorite),
                contentDescription = "Back Icon"
            )
        },
        title = {
            Text(
                "Details",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = {
            Icon(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .clickable(onClick = {
                        backClick()
                    }),
                painter = painterResource(R.drawable.regular_outline_arrow_left),
                contentDescription = "Back Icon"
            )
        },

        )

}