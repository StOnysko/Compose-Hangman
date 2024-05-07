package com.example.hangman.ui.theme.navigation.logic

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hangman.ui.theme.words.Words


@Composable
fun SecretWord(word: String) {
    Row {
        for (char in word) {
            Text(
                text = char.toString(), style = TextStyle(
                    textDecoration = TextDecoration.Underline,
                    color = Color.Black,
                    fontSize = 40.sp
                )
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
}


fun invisibleWord(secretWord: String): String {
    return " ".repeat(secretWord.length)
}
fun getRandomString(): String {
    return Words.listOfWords.random()
}

fun revealWord(secretWord: String, guessedLetters: Set<Char>): String {
    return secretWord.map { char ->
        if (char in guessedLetters) char else '_'
    }.joinToString(separator = "")
}