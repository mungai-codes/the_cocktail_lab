package com.mungai.thecocktaillabs.presentation.settingsdrawer.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.TextStyle
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
            style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontSize = 40.sp,
                fontWeight = FontWeight.SemiBold
            ),
            textAlign = TextAlign.Start
        )
        Divider(thickness = 3.dp, color = MaterialTheme.colors.primary)
        ThemeSwitch(
            label = "Dark Theme",
            checked = isDarkThemeChecked,
            onCheckedChange = setDarkThemeOn
        )
        ThemeSwitch(
            label = "Light Theme",
            checked = isLightThemeChecked,
            onCheckedChange = setLightThemeOn
        )
    }
}

@Composable
fun ThemeSwitch(
    label: String,
    checked: Boolean,
    onCheckedChange: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontSize = 30.sp
            )
        )
        Switch(
            checked = checked,
            onCheckedChange = { onCheckedChange() },
            modifier = Modifier.scale(1.5f),
            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colors.primary
            )
        )
    }
}
