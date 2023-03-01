package com.mungai.thecocktaillabs.data.remote.response

import com.mungai.thecocktaillabs.data.remote.dto.DrinkDto

data class MainResponse(
    val drinks: List<DrinkDto>
)
