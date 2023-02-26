package com.game.thecocktaillabs.presentation.settingsdrawer

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.game.thecocktaillabs.data.datastore.Theme
import com.game.thecocktaillabs.datastore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(

) : ViewModel() {

    fun setDarkTheme(context: Context) {
        viewModelScope.launch {
            context.datastore.updateData {
                it.copy(theme = Theme.DARK)
            }
        }
    }

    fun setLightTheme(context: Context) {
        viewModelScope.launch {
            context.datastore.updateData {
                it.copy(theme = Theme.LIGHT)
            }
        }
    }

}