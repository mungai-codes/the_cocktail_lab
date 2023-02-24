package com.game.thecocktaillabs.data.remote.dto

import com.squareup.moshi.Json

data class DrinkDto(
    @field:Json(name = "dateModified")
    val dateModified: String?,
    @field:Json(name = "idDrink")
    val idDrink: String?,
    @field:Json(name = "")
    val strAlcoholic: String?,
    @field:Json(name = "strCategory")
    val strCategory: String?,
    @field:Json(name = "strCreativeCommonsConfirmed")
    val strCreativeCommonsConfirmed: String?,
    @field:Json(name = "strDrink")
    val strDrink: String?,
    @field:Json(name = "strDrinkAlternate")
    val strDrinkAlternate: String?,
    @field:Json(name = "strDrinkThumb")
    val strDrinkThumb: String?,
    @field:Json(name = "strGlass")
    val strGlass: String?,
    @field:Json(name = "strIBA")
    val strIBA: String?,
    @field:Json(name = "strImageAttribution")
    val strImageAttribution: String?,
    @field:Json(name = "strImageSource")
    val strImageSource: String?,
    @field:Json(name = "strIngredient1")
    val strIngredient1: String?,
    @field:Json(name = "strIngredient10")
    val strIngredient10: String?,
    @field:Json(name = "strIngredient11")
    val strIngredient11: String?,
    @field:Json(name = "strIngredient12")
    val strIngredient12: String?,
    @field:Json(name = "strIngredient13")
    val strIngredient13: String?,
    @field:Json(name = "strIngredient14")
    val strIngredient14: String?,
    @field:Json(name = "strIngredient15")
    val strIngredient15: String?,
    @field:Json(name = "strIngredient2")
    val strIngredient2: String?,
    @field:Json(name = "strIngredient3")
    val strIngredient3: String?,
    @field:Json(name = "strIngredient4")
    val strIngredient4: String?,
    @field:Json(name = "strIngredient5")
    val strIngredient5: String?,
    @field:Json(name = "strIngredient6")
    val strIngredient6: String?,
    @field:Json(name = "strIngredient7")
    val strIngredient7: String?,
    @field:Json(name = "strIngredient8")
    val strIngredient8: String?,
    @field:Json(name = "strIngredient9")
    val strIngredient9: String?,
    @field:Json(name = "strInstructions")
    val strInstructions: String?,
    @field:Json(name = "strInstructionsDE")
    val strInstructionsDE: String?,
    @field:Json(name = "strInstructionsES")
    val strInstructionsES: String?,
    @field:Json(name = "strInstructionsFR")
    val strInstructionsFR: String?,
    @field:Json(name = "strInstructionsIT")
    val strInstructionsIT: String?,
    @field:Json(name = "strInstructionsZH-HANS")
    val strInstructionsZhHans: String?,
    @field:Json(name = "strInstructionsZH-HANT")
    val strInstructionsZhHant: String?,
    @field:Json(name = "strMeasure1")
    val strMeasure1: String?,
    @field:Json(name = "strMeasure10")
    val strMeasure10: String?,
    @field:Json(name = "strMeasure11")
    val strMeasure11: String?,
    @field:Json(name = "strMeasure12")
    val strMeasure12: String?,
    @field:Json(name = "strMeasure13")
    val strMeasure13: String?,
    @field:Json(name = "strMeasure14")
    val strMeasure14: String?,
    @field:Json(name = "strMeasure15")
    val strMeasure15: String?,
    @field:Json(name = "strMeasure2")
    val strMeasure2: String?,
    @field:Json(name = "strMeasure3")
    val strMeasure3: String?,
    @field:Json(name = "strMeasure4")
    val strMeasure4: String?,
    @field:Json(name = "strMeasure5")
    val strMeasure5: String?,
    @field:Json(name = "strMeasure6")
    val strMeasure6: String?,
    @field:Json(name = "strMeasure7")
    val strMeasure7: String?,
    @field:Json(name = "strMeasure8")
    val strMeasure8: String?,
    @field:Json(name = "strMeasure9")
    val strMeasure9: String?,
    @field:Json(name = "strTags")
    val strTags: String?,
    @field:Json(name = "strVideo")
    val strVideo: String?
) {
    fun toCategorySearchDto() : CategorySearchDto {
        return CategorySearchDto(
            idDrink = idDrink,
            strDrink = strDrink,
            strDrinkThumb = strDrinkThumb
        )
    }
}