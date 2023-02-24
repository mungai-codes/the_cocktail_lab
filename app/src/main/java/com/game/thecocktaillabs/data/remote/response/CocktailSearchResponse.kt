package com.game.thecocktaillabs.data.remote.response

import com.game.thecocktaillabs.data.remote.dto.DrinkDto

data class CocktailSearchResponse(
    val drinks: List<DrinkDto>
)
