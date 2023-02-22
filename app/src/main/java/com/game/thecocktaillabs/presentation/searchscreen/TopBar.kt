package com.game.thecocktaillabs.presentation.searchscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Chip
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    normalSearch: (String) -> Unit,
    alcoholicSearch: (String) -> Unit,
    nonAlcoholicSearch: (String) -> Unit
) {
    val listItems = arrayOf("Normal Search", "Non-Alcoholic", "Alcoholic")

    val randomItems = listOf(
        "magarita",
        "vodka",
        "guarana",
        "Schnapps",
        "four cousins",
        "gibleys",
        "konyagi",
        "tusker cider",
        "blue moon vodka"
    )

    var selectedItem by remember {
        mutableStateOf(listItems[0])
    }

    var expanded by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(160.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {

            Surface(
                modifier = Modifier
                    .width(200.dp)
                    .padding(top = 20.dp),
                shape = RoundedCornerShape(10.dp),
                elevation = 8.dp,
                border = BorderStroke(1.dp, MaterialTheme.colors.primary)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = selectedItem,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 16.dp)
                    )
                    IconButton(onClick = { }) {
                        ExposedDropdownMenuDefaults.TrailingIcon(
                            expanded = expanded
                        )
                    }
                }
            }

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                listItems.forEach { selectedOption ->

                    DropdownMenuItem(onClick = {
                        selectedItem = selectedOption
                        expanded = false
                    }) {
                        Text(
                            text = selectedOption,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
        when (selectedItem) {
            "Normal Search" -> {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = {
                        Text(
                            text = "Search cocktails",
                            fontSize = 12.sp,
                            color = Color.LightGray
                        )
                    },
                    leadingIcon = {
                        IconButton(onClick = { normalSearch("") }) {
                            Icon(
                                imageVector = Icons.Rounded.Search,
                                contentDescription = "recipe search"
                            )
                        }
                    },
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = MaterialTheme.colors.primary,
                        focusedBorderColor = MaterialTheme.colors.primary
                    ),
                )
            }

            "Non-Alcoholic" -> {

                LazyRow(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    contentPadding = PaddingValues(horizontal = 20.dp),
                ) {
                    items(randomItems.shuffled()) { item ->
                        Chip(onClick = { nonAlcoholicSearch(item) }) {
                            Text(text = item, fontFamily = FontFamily.SansSerif)
                        }
                    }
                }
            }

            "Alcoholic" -> {

                LazyRow(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    contentPadding = PaddingValues(horizontal = 20.dp),
                ) {
                    items(randomItems.shuffled().take(5)) { item ->
                        Chip(onClick = { alcoholicSearch(item) }) {
                            Text(text = item, fontFamily = FontFamily.SansSerif)
                        }
                    }
                }
            }
        }
    }
}