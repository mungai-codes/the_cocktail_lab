package com.game.thecocktaillabs.data.datastore

import kotlinx.serialization.Serializable

@Serializable
data class AppSettings(
    val theme: Theme = Theme.LIGHT
)

enum class Theme {
    DARK, LIGHT
}