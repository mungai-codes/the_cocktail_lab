package com.game.thecocktaillabs.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite_cocktails")
data class FavouriteCocktailEntity(
    @PrimaryKey
    val idDrink: String,
    val strAlcoholic: String?,
    val strCategory: String?,
    val strDrink: String?,
    val strDrinkThumb: String?,
    val strVideo: String?
)