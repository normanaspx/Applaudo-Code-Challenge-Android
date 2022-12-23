package com.normanaspx.pokeapi.ui.composables


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.normanaspx.pokeapi.model.Show
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ShowCard(
    show: Show,
    click: () -> Unit
){
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .clickable(onClick = click)
            .fillMaxWidth()
            .height(216.dp),
        elevation = 10.dp,

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            GlideImage(
                imageModel = {show.getImageURL()},
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                ),
                modifier = Modifier
                    .height(136.dp)
                    .fillMaxWidth()
            )
            show.name.let { title ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top=16.dp, bottom=12.dp, start = 8.dp, end=40.dp)
                ){
                    Text(
                        color = Color(0xFF6B6B83),
                        text = title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Justify
                    )
                }
            }
        }
    }
}
