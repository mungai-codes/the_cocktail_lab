package com.mungai.thecocktaillabs.data.remote.dto

import com.mungai.thecocktaillabs.domain.model.Drink

data class GlassSearchDto(
    val idDrink: String,
    val strDrink: String,
    val strDrinkThumb: String
) {
    fun toDrink(): Drink {
        return Drink(
            idDrink = idDrink,
            strDrink = strDrink,
            strDrinkThumb = strDrinkThumb,
            strDrinkAlternate = null,
            strTags = null,
            strVideo = null,
            strCategory = null,
            strIBA = null,
            strAlcoholic = null,
            strGlass = null,
            strInstructions = null,
            strInstructionsES = null,
            strInstructionsDE = null,
            strInstructionsFR = null,
            strInstructionsIT = null,
            strInstructionsZhHans = null,
            strInstructionsZhHant = null,
            strImageSource = null,
            strImageAttribution = null,
            strCreativeCommonsConfirmed = null,
            dateModified = null,
            ingredients = null
        )
    }
}