package com.game.thecocktaillabs.data.remote.response

import com.game.thecocktaillabs.data.remote.dto.FilterDto

data class FilterResponse(
    val drinks: List<FilterDto>
)