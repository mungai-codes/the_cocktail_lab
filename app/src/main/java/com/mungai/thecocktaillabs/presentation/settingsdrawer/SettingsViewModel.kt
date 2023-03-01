package com.mungai.thecocktaillabs.presentation.settingsdrawer

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mungai.thecocktaillabs.data.datastore.Theme
import com.mungai.thecocktaillabs.datastore
import com.mungai.thecocktaillabs.di.IoDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    fun setDarkTheme(context: Context) {
        viewModelScope.launch(ioDispatcher) {
            context.datastore.updateData {
                it.copy(theme = Theme.DARK)
            }
        }
    }

    fun setLightTheme(context: Context) {
        viewModelScope.launch(ioDispatcher) {
            context.datastore.updateData {
                it.copy(theme = Theme.LIGHT)
            }
        }
    }

}