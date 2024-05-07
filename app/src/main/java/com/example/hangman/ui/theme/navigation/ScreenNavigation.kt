package com.example.hangman.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hangman.ui.theme.navigation.screens.HowToPlayScreen
import com.example.hangman.ui.theme.navigation.screens.LoseScreen
import com.example.hangman.ui.theme.navigation.screens.StartGame
import com.example.hangman.ui.theme.navigation.screens.StartScreen
import com.example.hangman.ui.theme.navigation.screens.WinScreen

@Composable
fun ScreenNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.StartScreen.route) {
        composable(Screens.StartScreen.route) {
            StartScreen(navController = navController)
        }

        composable(Screens.HowToPlayScreen.route) {
            HowToPlayScreen(navController = navController)
        }

        composable(Screens.Game.route) {
            StartGame(navController = navController)
        }

        composable(Screens.WonScreen.route) {
            WinScreen(navController = navController)
        }

        composable(Screens.LoseScreen.route) {
            LoseScreen(navController = navController)
        }
    }
}


