package com.game.thecocktaillabs.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val darkColorScheme = darkColors(
    primary = Color(0xfffbd24a),
    primaryVariant = Purple700,
    secondary = Teal200,
    background = Color(0xff121212),
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color(0xffffffff),
)

private val lightColorScheme = lightColors(
    primary = Color(0xff4ecdc4),
    primaryVariant = Purple700,
    secondary = Teal200,
    background = Color(0xfff5f5f5),
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color(0xff333333),
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