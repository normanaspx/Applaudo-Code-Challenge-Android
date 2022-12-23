package com.normanaspx.pokeapi.ui.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.normanaspx.pokeapi.model.Season
import com.normanaspx.pokeapi.model.Show
import com.normanaspx.pokeapi.model.ShowDetail
import com.normanaspx.pokeapi.ui.Screen
import com.normanaspx.pokeapi.ui.SharedViewModel
import com.normanaspx.pokeapi.ui.composables.InfoCard
import com.normanaspx.pokeapi.ui.composables.ShowCard
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage


@Composable
fun DetailCard(
    show: ShowDetail
){
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            //.clickable(onClick = click)
            .fillMaxWidth()
            .height(232.dp),
        elevation = 10.dp,

        ) {
        Column(
            horizontalAlignment = Alignment.Start,
        ) {
            Box{
                GlideImage(
                    imageModel = {show.getImageURL()},
                    imageOptions = ImageOptions(
                        contentScale = ContentScale.FillWidth,
                        alignment = Alignment.Center
                    ),
                    modifier = Modifier
                        .height(262.dp)
                        .fillMaxWidth()
                )
                show.original_name.let {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp, start = 16.dp)
                            .align(Alignment.BottomStart)
                    ){
                        Text(
                            text = show.name,
                            color = Color(0xFFFBFAFE),
                            fontSize = 12.sp
                        )
                    }
                }
                show.name.let {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 40.dp, start = 16.dp)
                            .align(Alignment.BottomStart)
                    ){
                        Text(
                            text = show.name,
                            color = Color(0xFFFBFAFE),
                            fontSize = 34.sp
                        )
                    }
                }

            }
            Text(
                text = "Summary",
                color = Color(0xFF6200EE),
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 24.dp, start = 16.dp)

            )
            show.overview.let { title ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 12.dp, start = 16.dp, end = 40.dp)
                ){
                    Text(
                        color = Color(0xFF6B6B83),
                        text = title,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Justify
                    )
                }
            }
            SeasonsList(show.seasons)
        }
    }
}

@Composable
fun SeasonsList(seasons: List<Season>){
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(seasons.size) { show ->
                InfoCard(season = seasons[show])
            }
        }
    }
}

