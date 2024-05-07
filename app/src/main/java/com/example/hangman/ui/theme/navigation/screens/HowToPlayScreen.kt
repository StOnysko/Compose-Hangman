package com.example.hangman.ui.theme.navigation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hangman.R
import com.example.hangman.ui.theme.PixelSans

@Composable
fun HowToPlayScreen(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        Column {
            ScreenHeader()
            AboutRows(
                R.drawable.hangman_icon,
                "Hangman",
                "-> Hangman is a word-guessing game where one player thinks of a word and the other tries to guess it letter by letter before a stick figure is fully drawn."
            )
            AboutRows(
                R.drawable.gamepad,
                "Rules",
                "-> Guess letters to uncover a word before a stick figure is fully drawn."
            )
            AboutRows(R.drawable.question_mark, "About game", "-> Created for GDG Compose camp. ")
        }
    }
}

@Composable
private fun ScreenHeader() {
    Text(
        text = "How To Play?",
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 20.dp),
        color = Color.Black,
        fontFamily = PixelSans,
        fontSize = 45.sp
    )
}

@Composable
private fun AboutRows(image: Int, headerText: String, underHeaderText: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 10.dp, end = 20.dp)
    ) {
        CustomColumn(image = image, headerText = headerText, underHeaderText = underHeaderText)
    }
}

@Composable
private fun CustomColumn(image: Int, headerText: String, underHeaderText: String) {
    Image(
        alignment = Alignment.Center,
        painter = painterResource(id = image),
        contentDescription = "Game rules",
        modifier = Modifier.size(50.dp)
    )
    Column {
        CustomRowHeaderText(content = headerText)
        CustomUnderHeaderText(content = underHeaderText)
    }
}

@Composable
private fun CustomRowHeaderText(content: String) {
    Text(
        modifier = Modifier.padding(start = 10.dp),
        text = content,
        fontFamily = PixelSans,
        color = Color.Black,
        fontSize = 30.sp
    )
}

@Composable
private fun CustomUnderHeaderText(content: String) {
    Text(
        modifier = Modifier.padding(start = 10.dp),
        text = content,
        color = Color(83, 82, 82, 255),
        fontFamily = PixelSans,
        fontSize = 20.sp
    )
}