package com.example.hangman.ui.theme.navigation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hangman.R
import com.example.hangman.ui.theme.PixelSans
import com.example.hangman.ui.theme.navigation.Screens

@Composable
fun StartScreen(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        ApplicationName()
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CustomImage()
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 30.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column {
                CustomButton("Let`s Hang!", navController = navController, Screens.Game, true)
                CustomButton(
                    "How To Play?",
                    navController = navController,
                    Screens.HowToPlayScreen,
                    false
                )
            }
        }
    }
}

@Composable
private fun ApplicationName() {
    Text(
        text = "HANGMAN",
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 50.dp),
        textAlign = TextAlign.Center,
        fontFamily = PixelSans,
        fontSize = 70.sp
    )
}

@Composable
private fun CustomImage() {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp, start = 20.dp, end = 20.dp),
        painter = painterResource(id = R.drawable.hangman_icon),
        contentDescription = "Application logo"
    )
}

@Composable
private fun CustomButton(
    content: String,
    navController: NavController,
    screens: Screens,
    value: Boolean
) {
    val buttonPadding = 60
    Button(
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, color = Color.Blue),
        onClick = {
            navController.navigate(screens.route) {
                popUpTo(Screens.StartScreen.route) {
                    inclusive = value
                }
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = buttonPadding.dp, end = buttonPadding.dp, bottom = 10.dp),
        colors = ButtonDefaults.buttonColors(Color.Black)
    ) {
        CustomButtonText(content)
    }
}

@Composable
private fun CustomButtonText(text: String) {
    Text(
        lineHeight = 35.sp,
        text = text,
        color = Color.White,
        fontSize = 35.sp,
        fontFamily = PixelSans,
        textAlign = TextAlign.Center
    )
}