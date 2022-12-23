package com.normanaspx.pokeapi.ui.composables

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.normanaspx.pokeapi.ui.Screen
import com.normanaspx.pokeapi.ui.SharedViewModel
import com.normanaspx.pokeapi.ui.detail.SuccessDetailView
import com.normanaspx.pokeapi.ui.shows.HomeScreen

@Composable
fun JetpackComposeAppScreen(
    viewModel: SharedViewModel
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){
            HomeScreen(navController = navController, viewModel = viewModel)
        }
        composable(
            route = Screen.DetailScreen.route + "/{show}",
            arguments = listOf(
                navArgument("show"){
                    type = NavType.StringType
                }
            )
        ){
            val show = remember {
                it.arguments?.getString("show") ?: ""
            }.toInt()
            SuccessDetailView(show = show)
        }
    }
}
