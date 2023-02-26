package com.game.thecocktaillabs.presentation.settingsdrawer.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ThemeItem(
    isDarkThemeChecked: Boolean,
    isLightThemeChecked: Boolean,
    setDarkThemeOn: () -> Unit,
    setLightThemeOn: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Theme",
            fontFamily = FontFamily.SansSerif,
            fontSize = 40.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Start,
            color = MaterialTheme.colors.onPrimary
        )
        Divider(thickness = 3.dp, color = MaterialTheme.colors.onPrimary)
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Dark Theme:",
                fontFamily = FontFamily.SansSerif,
                fontSize = 30.sp
            )
            Switch(
                checked = isDarkThemeChecked,
                onCheckedChange = { setDarkThemeOn() },
                modifier = Modifier.scale(1.5f)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Light Theme:",
                fontFamily = FontFamily.SansSerif,
                fontSize = 30.sp
            )
            Switch(
                checked = isLightThemeChecked,
                onCheckedChange = { setLightThemeOn() },
                modifier = Modifier.scale(1.5f)
            )
        }
    }
}