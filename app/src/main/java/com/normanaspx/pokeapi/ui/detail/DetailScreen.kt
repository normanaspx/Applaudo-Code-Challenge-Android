package com.normanaspx.pokeapi.ui.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.normanaspx.pokeapi.utils.Response
import com.normanaspx.pokeapi.ui.SharedViewModel

@Composable
fun SuccessDetailView(
    modifier: Modifier = Modifier,
    show: Int,
    detailViewModel: SharedViewModel = hiltViewModel(),
) {

    fun getDetailFromNetwork() {
        detailViewModel.getShowDetail(show)
    }

    getDetailFromNetwork()

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        when(val gamesResponse = detailViewModel.detailState.value){
            is Response.Loading -> {
                Text(text = "Loading")
            }
            is Response.Success -> {
                gamesResponse.data?.let {
                    DetailCard(
                        show = it
                    )
                }
            }
            is Response.Failure -> {
                Text(text = "Error")
            }
        }
    }

}