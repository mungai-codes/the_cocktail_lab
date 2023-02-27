package com.game.thecocktaillabs.data.remote.dto

import com.game.thecocktaillabs.domain.model.Drink
import com.squareup.moshi.Json

data class CategorySearchDto(
    @field:Json(name = "idDrink")
    val idDrink: String?,
    @field:Json(name = "strDrink")
    val strDrink: String?,
    @field:Json(name = "strDrinkThumb")
    val strDrinkThumb: String?
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
