package com.mungai.thecocktaillabs.data.remote.response

import com.mungai.thecocktaillabs.data.remote.dto.FilterSearchDto

data class AlcoholFilterSearchResponse(
    val drinks: List<FilterSearchDto>
)