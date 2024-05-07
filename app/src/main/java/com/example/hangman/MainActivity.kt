package com.example.hangman

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.hangman.ui.theme.HangmanTheme
import com.example.hangman.ui.theme.navigation.ScreenNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = getColor(R.color.white)
            window.navigationBarColor = getColor(R.color.black)
            ScreenNavigation()
        }
    }
}
