package com.mungai.thecocktaillabs.presentation.searchscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.game.thecocktaillabs.R
import com.mungai.thecocktaillabs.R
import com.mungai.thecocktaillabs.domain.model.Drink

@Composable
fun ResultItemCard(
    modifier: Modifier = Modifier,
    drink: Drink,
    onCocktailClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .height(140.dp)
            .clickable { drink.idDrink?.let { onCocktailClick() } },
        elevation = 8.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(drink.strDrinkThumb)
                    .crossfade(true)
                    .placeholder(R.drawable.loading_img)
                    .error(R.drawable.ic_broken_image)
                    .build(),
                contentDescription = drink.strDrink,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopStart)
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color.DarkGray.copy(alpha = 0.5f),
                                Color.LightGray.copy(alpha = 0.8f),
                                Color.Transparent,
                            )
                        )
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = drink.strDrink!!,
                    color = Color(0xFFF4F4F4),
                    fontSize = 15.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 2,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(horizontal = 3.dp)
                )
            }
        }
    }
}