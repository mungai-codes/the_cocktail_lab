package com.game.thecocktaillabs.data.remote.response

import com.game.thecocktaillabs.data.remote.dto.GlassSearchDto

data class GlassTypeSearchResponse(
    val drinks: List<GlassSearchDto>
)