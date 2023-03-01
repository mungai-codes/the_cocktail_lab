package com.mungai.thecocktaillabs.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mungai.thecocktaillabs.domain.model.Filter

@Entity(tableName = "alcohol_filters")
data class FilterEntity(
    @PrimaryKey
    val id: Int? = null,
    val filter: String
) {
    fun toFilter(): Filter {
        return Filter(
            strAlcoholic = filter
        )
    }
}
