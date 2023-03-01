package com.game.thecocktaillabs.domain.model

import com.game.thecocktaillabs.common.Ingredient
import com.game.thecocktaillabs.data.local.entity.FavouriteCocktailEntity

data class Drink(
    val idDrink: String?,
    val strDrink: String?,
    val strDrinkAlternate: String?,
    val strTags: String?,
    val strVideo: String?,
    val strCategory: String?,
    val strIBA: String?,
    val strAlcoholic: String?,
    val strGlass: String?,
    val strInstructions: String?,
    val strInstructionsES: String?,
    val strInstructionsDE: String?,
    val strInstructionsFR: String?,
    val strInstructionsIT: String?,
    val strInstructionsZhHans: String?,
    val strInstructionsZhHant: String?,
    val strDrinkThumb: String?,
    val strImageSource: String?,
    val strImageAttribution: String?,
    val strCreativeCommonsConfirmed: String?,
    val dateModified: String?,
    val ingredients: List<Ingredient>?
) {
    fun toFavouriteCocktalEntity(): FavouriteCocktailEntity {
        return FavouriteCocktailEntity(
            idDrink!!,
            strAlcoholic,
            strCategory,
            strDrinkThumb,
            strDrink,
            strVideo
        )
    }
}