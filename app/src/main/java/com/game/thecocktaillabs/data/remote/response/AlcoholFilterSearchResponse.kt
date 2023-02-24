package com.game.thecocktaillabs.data.remote.response

import com.game.thecocktaillabs.data.remote.dto.FilterSearchDto

data class AlcoholFilterSearchResponse(
    val drinks: List<FilterSearchDto>
)