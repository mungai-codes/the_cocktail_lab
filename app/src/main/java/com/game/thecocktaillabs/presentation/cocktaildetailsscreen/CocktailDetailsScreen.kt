package com.game.thecocktaillabs.presentation.cocktaildetailsscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.SmartDisplay
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.game.thecocktaillabs.R
import com.game.thecocktaillabs.presentation.ui.theme.TheCocktailLabsTheme

@Composable
fun CocktailDetailsScreen() {

    val scaffoldState = rememberScaffoldState()

    var isLiked by remember {
        mutableStateOf(false)
    }

    val (favouriteStatus, tint) = when (isLiked) {
        true -> Pair(Icons.Outlined.Favorite, MaterialTheme.colors.primary)
        false -> Pair(Icons.Outlined.FavoriteBorder, Color.Black)
    }

    Scaffold(
        scaffoldState = scaffoldState
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.favourite_cocktail),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )
                IconButton(
                    onClick = { isLiked = !isLiked },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 8.dp, end = 8.dp)
                ) {
                    Icon(
                        imageVector = favouriteStatus,
                        contentDescription = "favourite",
                        tint = tint,
                        modifier = Modifier.size(40.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .fillMaxWidth()
                        .background(
                            brush = Brush.verticalGradient(
                                listOf(
                                    Color.Transparent,
                                    Color.LightGray,
                                    Color.DarkGray
                                )
                            )
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Martini Strong one this",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFFF4F4F4),
                        fontSize = 25.sp,
                        textAlign = TextAlign.Start,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Outlined.SmartDisplay,
                            contentDescription = "youtube",
                            tint = Color(0xFFFE0000),
                            modifier = Modifier
                                .size(40.dp)
                                .padding(end = 8.dp)
                        )
                    }
                }
            }

            CocktailDetails(modifier = Modifier.weight(1f), heading = "Ingredients")

            CocktailDetails(modifier = Modifier.weight(1f), heading = "instructions")

        }
    }
}

@Preview(showBackground = true)
@Composable
fun CocktailDetailsPreview() {
    TheCocktailLabsTheme {
        CocktailDetailsScreen()
    }
}