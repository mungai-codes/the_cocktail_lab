package com.mungai.thecocktaillabs.data.remote.response

import com.mungai.thecocktaillabs.data.remote.dto.FilterDto

data class FilterResponse(
    val drinks: List<FilterDto>
)