package com.example.coffeapp.presentation.screen.welcomescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.coffeapp.R
import com.example.coffeapp.presentation.navigation.Routes
import com.example.coffeapp.presentation.theme.LightBrown


@Composable
fun WelcomeScreen(navController: NavHostController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black),

        ) {
        Image(
            painter = painterResource(R.drawable.image_splash), contentDescription = "Welcome Image"
        )
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 70.dp)
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = "Fall in Love with Coffee in\n BlissFull Delight!",
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                textAlign = TextAlign.Center,
                text = "Welcome to our cozy Coffee corner. Where every cup is a delight for you.",
                color = Color.LightGray,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal
            )


            Spacer(modifier = Modifier.height(50.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightBrown, contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    navController.navigate(Routes.HomeScreen) {
                        // WelcomeScreen ko backstack se hata deta hai
                        popUpTo(Routes.WelcomeScreen) {
                            inclusive = true
                        }
                    }
                }) {
                Text(text = "Get Started", fontSize = 18.sp)

            }
        }
    }
}