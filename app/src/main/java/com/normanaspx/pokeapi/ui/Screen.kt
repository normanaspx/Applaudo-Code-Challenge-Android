package com.normanaspx.pokeapi.ui

sealed class Screen(val route: String){
    object SplashScreen : Screen("splash")
    object MainScreen : Screen("home")
    object DetailScreen : Screen("detail")
}
