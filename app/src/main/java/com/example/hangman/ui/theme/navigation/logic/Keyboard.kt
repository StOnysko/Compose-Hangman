package com.example.hangman.ui.theme.navigation.logic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Keyboard(
    livesCount: Int,
    randomGeneratedWord: String,
    guessedLetters: Set<Char>,
    onLetterGuessed: (Char) -> Unit,
    onIncorrectGuess: () -> Unit
) {
    if (livesCount > 0) {
        val letters = listOf(
            listOf('A', 'B', 'C', 'D', 'E', 'F'),
            listOf('G', 'H', 'I', 'J', 'K', 'L'),
            listOf('M', 'N', 'O', 'P', 'Q', 'R'),
            listOf('S', 'T', 'U', 'V', 'W', 'X'),
            listOf('Y', 'Z')
        )

        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            letters.forEach { row ->
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    row.forEach { letter ->
                        Button(
                            onClick = {
                                if (letter in randomGeneratedWord.toSet()) {
                                    onLetterGuessed(letter)
                                } else {
                                    onIncorrectGuess()
                                }
                            },
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .padding(4.dp)
                                .weight(1f)
                                .size(50.dp),
                            colors = ButtonDefaults.buttonColors(Color.Black)
                        ) {
                            Text(
                                text = letter.toString(),
                                fontSize = 25.sp,
                                textAlign = TextAlign.Center,
                                style = TextStyle(
                                    textDecoration = if (letter in guessedLetters) TextDecoration.None else TextDecoration.Underline
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}