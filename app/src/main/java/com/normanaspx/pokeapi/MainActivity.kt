package com.normanaspx.pokeapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.arudo.jetpackcompose.ui.theme.MainTheme
import com.normanaspx.pokeapi.ui.SharedViewModel
import com.normanaspx.pokeapi.ui.Screen
import com.normanaspx.pokeapi.ui.composables.AppScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainTheme {
                AppScreen(viewModel)
            }
        }

        supportActionBar?.hide()

    }
}