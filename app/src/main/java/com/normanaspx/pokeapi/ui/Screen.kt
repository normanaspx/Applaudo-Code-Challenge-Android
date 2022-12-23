package com.normanaspx.pokeapi.ui

sealed class Screen(val route: String){
    object MainScreen : Screen("home")
    object DetailScreen : Screen("detail")
}
