package com.game.thecocktaillabs.data.remote.dto

import com.game.thecocktaillabs.domain.model.Drink

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
            strIngredient1 = null,
            strIngredient2 = null,
            strIngredient3 = null,
            strIngredient4 = null,
            strIngredient5 = null,
            strIngredient6 = null,
            strIngredient7 = null,
            strIngredient8 = null,
            strIngredient9 = null,
            strIngredient10 = null,
            strIngredient11 = null,
            strIngredient12 = null,
            strIngredient13 = null,
            strIngredient14 = null,
            strIngredient15 = null,
            strMeasure1 = null,
            strMeasure2 = null,
            strMeasure3 = null,
            strMeasure4 = null,
            strMeasure5 = null,
            strMeasure6 = null,
            strMeasure7 = null,
            strMeasure8 = null,
            strMeasure9 = null,
            strMeasure10 = null,
            strMeasure11 = null,
            strMeasure12 = null,
            strMeasure13 = null,
            strMeasure14 = null,
            strMeasure15 = null,
            strImageSource = null,
            strImageAttribution = null,
            strCreativeCommonsConfirmed = null,
            dateModified = null,

            )
    }
}