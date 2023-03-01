package com.mungai.thecocktaillabs.data.remote.response

import com.mungai.thecocktaillabs.data.remote.dto.GlassSearchDto

data class GlassTypeSearchResponse(
    val drinks: List<GlassSearchDto>
)