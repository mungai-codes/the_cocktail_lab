package com.game.thecocktaillabs.presentation.homescreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.game.thecocktaillabs.R
import com.game.thecocktaillabs.domain.model.Drink

@Composable
fun FeaturedCocktail(
    modifier: Modifier = Modifier,
    drink: Drink,
    onClick: () -> Unit
) {

    Surface(
        modifier = modifier
            .height(240.dp)
            .width(170.dp)
            .clickable { onClick() },
        elevation = 8.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data = drink.strDrinkThumb)
                    .crossfade(true)
                    .error(R.drawable.ic_broken_image)
                    .placeholder(R.drawable.loading_img)
                    .build(),
                contentDescription = drink.strDrink,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )

            drink.strDrink?.let {
                Text(
                    text = it,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(3.dp)
                        .fillMaxWidth()
                        .align(Alignment.BottomStart),
                    color = MaterialTheme.colors.primary
                )
            }

        }
    }
}