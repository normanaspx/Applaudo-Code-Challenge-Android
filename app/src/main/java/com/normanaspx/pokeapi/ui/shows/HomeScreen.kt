package com.normanaspx.pokeapi.ui.shows

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.normanaspx.pokeapi.model.Show
import com.normanaspx.pokeapi.ui.SharedViewModel
import com.normanaspx.pokeapi.ui.Screen
import com.normanaspx.pokeapi.ui.composables.ShowCard
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    viewModel: SharedViewModel,
    navController: NavController
){

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("TV Shows")
                    }
                )
            }
        ){
            Column(
                Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
            ) {
                val lazyPagingItems = viewModel.showList("mostrated").collectAsLazyPagingItems()
                GridofShows(lazyPagingItems = lazyPagingItems, navController = navController, )

            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Chips(){
    Row() {
        Chip(
            enabled = true,
            shape = RoundedCornerShape(50),
            onClick = {
            },
            modifier = Modifier
                .padding(bottom = 16.dp, end = 8.dp)) {
            Text(text = "Top Rated", fontSize = 12.sp)
        }
        Chip(
            enabled = false,
            shape = RoundedCornerShape(50),
            onClick = {},
            modifier = Modifier
                .padding(bottom = 16.dp)) {
            Text(text = "Popular", fontSize = 12.sp)
        }
        Chip(
            enabled = false,
            shape = RoundedCornerShape(50),
            onClick = {},
            modifier = Modifier
                .padding(bottom = 16.dp)) {
            Text(text = "On TV", fontSize = 12.sp)
        }
    }
}

@Composable
fun GridofShows( lazyPagingItems: LazyPagingItems<Show>, navController: NavController){
    val listState = rememberLazyGridState()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        state = listState
    ) {
        if (lazyPagingItems.loadState.refresh == LoadState.Loading) {
            item {
                Text(
                    text = "Waiting for items to load...",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(CenterHorizontally)
                )
            }
        }
        items(lazyPagingItems.itemCount) { show ->
            lazyPagingItems[show]?.let {
                ShowCard(show = it){
                    navController.navigate( Screen.DetailScreen.route + "/${it.id}")
                }
            }
        }
    }
}