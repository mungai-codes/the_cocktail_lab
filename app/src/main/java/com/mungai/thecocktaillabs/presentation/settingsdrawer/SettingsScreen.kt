package com.mungai.thecocktaillabs.presentation.settingsdrawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mungai.thecocktaillabs.data.datastore.AppSettings
import com.mungai.thecocktaillabs.data.datastore.Theme
import com.mungai.thecocktaillabs.datastore
import com.mungai.thecocktaillabs.presentation.settingsdrawer.components.ThemeItem

@Composable
fun Settings(
    viewModel: SettingsViewModel = hiltViewModel()
) {

    val context = LocalContext.current

    val dataStoreState = context.datastore.data.collectAsState(initial = AppSettings()).value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
    ) {
        ThemeItem(
            isDarkThemeChecked = dataStoreState.theme != Theme.LIGHT,
            isLightThemeChecked = dataStoreState.theme != Theme.DARK,
            setDarkThemeOn = { viewModel.setDarkTheme(context) },
            setLightThemeOn = { viewModel.setLightTheme(context) },
            modifier = Modifier
                .padding(20.dp)
        )
    }

}