package com.game.thecocktaillabs.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val darkColorScheme = darkColors(
    primary = Color(0xffc83b4c), // deep red
    primaryVariant = Color(0xff9b2c3b), // darker red
    secondary = Color(0xffeda244), // orange
    background = Color(0xff1b1b1b), // dark gray
    surface = Color(0xff2d2d2d), // light black
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White
)


private val lightColorScheme = lightColors(
    primary = Color(0xffc83b4c), // deep red
    primaryVariant = Color(0xff9b2c3b), // darker red
    secondary = Color(0xffeda244), // orange
    background = Color(0xfff4f4f4), // light gray
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)


@Composable
fun TheCocktailLabsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorScheme
    } else {
        lightColorScheme
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}