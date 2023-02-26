package com.game.thecocktaillabs

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.datastore.dataStore
import androidx.navigation.compose.rememberNavController
import com.game.thecocktaillabs.data.datastore.AppSettings
import com.game.thecocktaillabs.data.datastore.AppSettingsSerializer
import com.game.thecocktaillabs.data.datastore.Theme
import com.game.thecocktaillabs.presentation.navigation.NavGraph
import com.game.thecocktaillabs.presentation.ui.theme.TheCocktailLabsTheme
import dagger.hilt.android.AndroidEntryPoint


val Context.datastore by dataStore("app_settings.json", AppSettingsSerializer)

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val appSettings = datastore.data.collectAsState(initial = AppSettings()).value

            val isDarkTheme = when (appSettings.theme) {
                Theme.DARK -> {
                    true
                }

                Theme.LIGHT -> {
                    false
                }
            }

            TheCocktailLabsTheme(darkTheme = isDarkTheme) {
                // A surface container using the 'background' color from the theme
                NavGraph(navController = rememberNavController())
            }
        }
    }
}



