package com.normanaspx.pokeapi.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.normanaspx.pokeapi.model.Season
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun InfoCard(
    season: Season
){
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            //  .clickable(onClick = click)
            .fillMaxWidth()
            .height(147.dp),
        elevation = 8.dp,
        ) {
          Row(
          ) {
              Column(
                  modifier = Modifier
                      .width(112.dp)
                      .height(147.dp)
              ) {
                  GlideImage(
                      imageModel = {season.getImageURL()},
                      imageOptions = ImageOptions(
                          contentScale = ContentScale.FillWidth,
                          alignment = Alignment.Center
                      )
                  )
              }
              Column(
                  modifier = Modifier
                      .padding(16.dp)
                      .verticalScroll(rememberScrollState())
              ) {

                  CardTitle(text ="Season ${season.getSeasonNumber()}")
                  CardBadge(text = "${season.episode_count} Epidodes")
                  CardBody(text = season.overview)

              }
          }
    }
}

@Composable
fun CardTitle(text: String){
    Text(
        color = Color(0xFF6B6B83),
        fontSize = 20.sp,
        text = text,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Composable
fun CardBadge(text: String){
    Text(
        color = Color(0xFF3700B3),
        fontSize = 12.sp,
        text = text,
        modifier = Modifier.padding(bottom = 8.dp)

    )
}

@Composable
fun CardBody(text: String){
    Text(
        color = Color(0xFF6B6B83),
        fontSize = 14.sp,
        text = text
    )
}