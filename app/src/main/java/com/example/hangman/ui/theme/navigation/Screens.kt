package com.example.hangman.ui.theme.navigation

sealed class Screens(val route: String) {
    object StartScreen : Screens("start")
    object HowToPlayScreen : Screens("howToPlay")
    object Game : Screens("game")
    object WonScreen : Screens("won")
    object LoseScreen : Screens("lose")
}