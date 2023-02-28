package com.game.thecocktaillabs.presentation.cocktaildetailsscreen.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExpandLess
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.game.thecocktaillabs.R
import com.game.thecocktaillabs.common.Ingredient
import com.game.thecocktaillabs.presentation.ui.theme.TheCocktailLabsTheme

@Composable
fun Instructions(
    instructions: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "INSTRUCTIONS",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
        )
        Surface(
            modifier = modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.surface)
        ) {
            Text(
                text = instructions,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Start,
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(10.dp)
            )
        }
    }

}

@Composable
fun Ingredients(
    ingredients: List<Ingredient>,
    modifier: Modifier = Modifier
) {

    var expanded by remember {
        mutableStateOf(true)
    }

    val (icon, description) = when (expanded) {
        false -> Pair(Icons.Outlined.ExpandMore, "expand more")
        true -> Pair(Icons.Outlined.ExpandLess, "close")
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "INGREDIENTS",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
            )
            IconButton(
                onClick = { expanded = !expanded },
            ) {
                Icon(imageVector = icon, contentDescription = description)
            }
        }
        AnimatedVisibility(visible = expanded) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                ingredients.forEach { ingredient ->
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp),
                        elevation = 6.dp,
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            if (ingredient.ingredient != null) {
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(4.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(
                                        text = "ingredient",
                                        textAlign = TextAlign.Center,
                                        fontFamily = FontFamily.SansSerif,
                                    )
                                    Text(
                                        text = ingredient.ingredient,
                                        textAlign = TextAlign.Center,
                                        fontFamily = FontFamily.SansSerif,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                            }
                            if (ingredient.measure != null) {
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(4.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(
                                        text = "quantity",
                                        textAlign = TextAlign.Center,
                                        fontFamily = FontFamily.SansSerif
                                    )
                                    Text(
                                        text = ingredient.measure,
                                        textAlign = TextAlign.Center,
                                        fontFamily = FontFamily.SansSerif,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                            }
                            ingredient.imageUrl?.let {
                                IngredientImage(
                                    url = it,
                                    modifier = Modifier.weight(0.5f)
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun IngredientImage(url: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.size(60.dp),
        shape = RoundedCornerShape(10.dp),
        color = Color.Transparent,
        border = BorderStroke(4.dp, MaterialTheme.colors.primary)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data = url)
                .crossfade(true)
                .placeholder(R.drawable.loading_img)
                .build(),
            contentDescription = url,
            contentScale = ContentScale.Crop,
            modifier = Modifier.padding(5.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun IngredientPreview() {
    TheCocktailLabsTheme {

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 20.dp)
        ) {

            item {
                Ingredients(
                    ingredients = listOf(
                        Ingredient(
                            ingredient = "moses",
                            measure = "one",
                            imageUrl = "www.thecocktaildb.com/images/ingredients/gin.png"
                        )
                    )
                )
            }

            item {
                Ingredients(
                    ingredients = listOf(
                        Ingredient(
                            ingredient = "moses",
                            measure = "one",
                            imageUrl = "www.thecocktaildb.com/images/ingredients/gin.png"
                        )
                    )
                )
            }

            item {
                Ingredients(
                    ingredients = listOf(
                        Ingredient(
                            ingredient = "moses",
                            measure = "one",
                            imageUrl = "www.thecocktaildb.com/images/ingredients/gin.png"
                        )
                    )
                )
            }

        }
    }
}