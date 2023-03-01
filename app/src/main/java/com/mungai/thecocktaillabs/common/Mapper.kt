package com.mungai.thecocktaillabs.common

import com.mungai.thecocktaillabs.data.remote.dto.DrinkDto
import com.mungai.thecocktaillabs.domain.model.Drink

fun DrinkDto.toDrink(): Drink {

    return Drink(
        idDrink,
        strDrink,
        strDrinkAlternate,
        strTags,
        strVideo,
        strCategory,
        strIBA,
        strAlcoholic,
        strGlass,
        strInstructions,
        strInstructionsES,
        strInstructionsDE,
        strInstructionsFR,
        strInstructionsIT,
        strInstructionsZhHans,
        strInstructionsZhHant,
        strDrinkThumb,
        strImageSource,
        strImageAttribution,
        strCreativeCommonsConfirmed,
        dateModified,
        ingredients = listOf(
            Ingredient(
                ingredient = strIngredient1,
                measure = strMeasure1,
                imageUrl = "https://www.themealdb.com/images/ingredients/${strIngredient1}.png"
            ),
            Ingredient(
                ingredient = strIngredient2,
                measure = strMeasure2,
                imageUrl = "https://www.themealdb.com/images/ingredients/${strIngredient2}.png"
            ),
            Ingredient(
                ingredient = strIngredient3,
                measure = strMeasure3,
                imageUrl = "https://www.themealdb.com/images/ingredients/${strIngredient3}.png"
            ),
            Ingredient(
                ingredient = strIngredient4,
                measure = strMeasure4,
                imageUrl = "https://www.themealdb.com/images/ingredients/${strIngredient4}.png"
            ),
            Ingredient(
                ingredient = strIngredient5,
                measure = strMeasure5,
                imageUrl = "https://www.themealdb.com/images/ingredients/${strIngredient5}.png"
            ),
            Ingredient(
                ingredient = strIngredient6,
                measure = strMeasure6,
                imageUrl = "https://www.themealdb.com/images/ingredients/${strIngredient6}.png"
            ),
            Ingredient(
                ingredient = strIngredient7,
                measure = strMeasure7,
                imageUrl = "https://www.themealdb.com/images/ingredients/${strIngredient7}.png"
            ),
            Ingredient(
                ingredient = strIngredient8,
                measure = strMeasure8,
                imageUrl = "https://www.themealdb.com/images/ingredients/${strIngredient8}.png"
            ),
            Ingredient(
                ingredient = strIngredient9,
                measure = strMeasure9,
                imageUrl = "https://www.themealdb.com/images/ingredients/${strIngredient9}.png"
            ),
            Ingredient(
                ingredient = strIngredient10,
                measure = strMeasure10,
                imageUrl = "https://www.themealdb.com/images/ingredients/${strIngredient10}.png"
            ),
            Ingredient(
                ingredient = strIngredient11,
                measure = strMeasure11,
                imageUrl = "https://www.themealdb.com/images/ingredients/${strIngredient11}.png"
            ),
            Ingredient(
                ingredient = strIngredient12,
                measure = strMeasure12,
                imageUrl = "https://www.themealdb.com/images/ingredients/${strIngredient12}.png"
            ),
            Ingredient(
                ingredient = strIngredient13,
                measure = strMeasure13,
                imageUrl = "https://www.themealdb.com/images/ingredients/${strIngredient13}.png"
            ),
            Ingredient(
                ingredient = strIngredient14,
                measure = strMeasure14,
                imageUrl = "https://www.themealdb.com/images/ingredients/${strIngredient14}.png"
            ),
            Ingredient(
                ingredient = strIngredient15,
                measure = strMeasure15,
                imageUrl = "https://www.themealdb.com/images/ingredients/${strIngredient15}.png"
            )
        ).filter { it.ingredient != null || it.measure != null }

    )
}