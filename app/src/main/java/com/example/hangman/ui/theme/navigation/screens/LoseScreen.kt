package com.example.hangman.ui.theme.navigation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hangman.ui.theme.PixelSans
import com.example.hangman.ui.theme.navigation.Screens

@Composable
fun LoseScreen(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "You Lose !",
                textAlign = TextAlign.Center,
                fontFamily = PixelSans,
                fontSize = 70.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 60.dp, end = 60.dp, top = 30.dp),
                onClick = {
                      navController.navigate(Screens.Game.route) {
                          popUpTo(Screens.LoseScreen.route) {
                              inclusive = true
                          }
                      }
                },
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text(
                    text = "Try Again",
                    fontFamily = PixelSans,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        }
    }
}
