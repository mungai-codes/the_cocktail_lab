package com.game.thecocktaillabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.game.thecocktaillabs.presentation.navigation.NavGraph
import com.game.thecocktaillabs.presentation.ui.theme.TheCocktailLabsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheCocktailLabsTheme(darkTheme = true) {
                // A surface container using the 'background' color from the theme
                NavGraph(navController = rememberNavController())
            }
        }
    }
}



