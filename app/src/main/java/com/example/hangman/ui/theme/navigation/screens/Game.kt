package com.example.hangman.ui.theme.navigation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hangman.R
import com.example.hangman.ui.theme.PixelSans
import com.example.hangman.ui.theme.navigation.Screens
import com.example.hangman.ui.theme.navigation.logic.Keyboard
import com.example.hangman.ui.theme.navigation.logic.SecretWord
import com.example.hangman.ui.theme.navigation.logic.getRandomString
import com.example.hangman.ui.theme.navigation.logic.invisibleWord
import com.example.hangman.ui.theme.navigation.logic.revealWord
import kotlinx.coroutines.delay

private var randomGeneratedWord: String = getRandomString()
private var hangmanLives: Int = 6

@Composable
fun StartGame(navController: NavController) {
    var revealedWord by remember { mutableStateOf(invisibleWord(randomGeneratedWord)) }
    val guessedLetters by remember { mutableStateOf(mutableSetOf<Char>()) }
    var currentHealth by remember { mutableIntStateOf(hangmanLives) }

    if (revealedWord == randomGeneratedWord){
        navController.navigate(Screens.WonScreen.route) {
            popUpTo(Screens.Game.route) {
                inclusive = true
            }
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            randomGeneratedWord = getRandomString()
        }
    }

    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        Column {
            // Top Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(color = Color.White)
            ) {
                TopGameBar(
                    lives = currentHealth,
                    onClick = {
                        navController.navigate(Screens.StartScreen.route) {
                            popUpTo(Screens.Game.route) {
                                inclusive = true
                            }
                        }
                    }
                )
            }
            // Hangman Image
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp),
                contentAlignment = Alignment.Center
            ) {
                SetHangmanImage(
                    lives = currentHealth,
                    navController = navController,
                    Screens.LoseScreen
                )
            }
            // Secret Word
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 20.dp), contentAlignment = Alignment.Center
            ) {
                SecretWord(word = revealedWord)
            }
            Spacer(modifier = Modifier.weight(1f))
            //Keyboard
            Box(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Keyboard(
                    livesCount = currentHealth,
                    randomGeneratedWord = randomGeneratedWord,
                    guessedLetters = guessedLetters,
                    onLetterGuessed = { letter ->
                        if (revealedWord != randomGeneratedWord) {
                            guessedLetters += letter
                            revealedWord = revealWord(randomGeneratedWord, guessedLetters)
                        }
                    },
                    onIncorrectGuess = {
                        currentHealth -= 1
                    }
                )
            }
        }
    }
}

@Composable
private fun TopGameBar(
    lives: Int,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .height(150.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .clickable(onClick = onClick)
                .size(40.dp)
                .padding(start = 10.dp, top = 10.dp),
            painter = painterResource(id = R.drawable.back_press),
            contentDescription = "Back press"
        )
        Text(
            text = "Hangman",
            modifier = Modifier,
            color = Color.Black,
            fontFamily = PixelSans,
            fontSize = 45.sp
        )

        Text(
            text = lives.toString(),
            modifier = Modifier.padding(end = 10.dp),
            color = Color.Black,
            fontFamily = PixelSans,
            fontSize = 45.sp
        )
    }
}

@Composable
private fun HangmanImage(image: Int) {
    val getImage = painterResource(id = image)
    Image(
        painter = getImage, contentDescription = "Hangman Image", modifier = Modifier.size(250.dp)
    )
}

@Composable
private fun SetHangmanImage(lives: Int, navController: NavController, screens: Screens) {
    when (lives) {
        6 -> {
            HangmanImage(image = R.drawable.stage_1)
        }

        5 -> {
            HangmanImage(image = R.drawable.stage_2)
        }

        4 -> {
            HangmanImage(image = R.drawable.stage_3)
        }

        3 -> {
            HangmanImage(image = R.drawable.stage_4)
        }

        2 -> {
            HangmanImage(image = R.drawable.stage_5)
        }

        1 -> {
            HangmanImage(image = R.drawable.stage_6)
        }

        0 -> {
            HangmanImage(image = R.drawable.stage_7)
            GameResultDelay(navController = navController, screens = screens)
        }
    }
}

@Composable
private fun GameResultDelay(navController: NavController, screens: Screens) {
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate(screens.route) {
            popUpTo(Screens.Game.route) {
                inclusive = true
            }
        }
    }
}