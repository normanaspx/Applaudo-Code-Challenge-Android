package com.normanaspx.pokeapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.arudo.jetpackcompose.ui.theme.JetpackComposeTheme
import com.normanaspx.pokeapi.ui.SharedViewModel
import com.normanaspx.pokeapi.ui.Screen
import com.normanaspx.pokeapi.ui.composables.JetpackComposeAppScreen
import com.normanaspx.pokeapi.ui.detail.SuccessDetailView
import com.normanaspx.pokeapi.ui.shows.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {

                JetpackComposeAppScreen(viewModel)
            }
        }

    }
}