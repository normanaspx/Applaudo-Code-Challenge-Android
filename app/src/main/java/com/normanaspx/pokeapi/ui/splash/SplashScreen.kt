package com.normanaspx.pokeapi.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.normanaspx.pokeapi.R
import com.normanaspx.pokeapi.ui.Screen
import kotlinx.coroutines.delay


/**
Created by Norman on 12/23/2022
 **/

@Composable
fun SplashScreen(){


     LaunchedEffect(key1 = true){
          delay(2000L)
         // navController.navigate(Screen.MainScreen.route)
     }

     Column(
          modifier = Modifier.fillMaxSize(),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally
     ) {

          Image(
               painter = painterResource(id = R.drawable.splash),
               "Splash",
               modifier = Modifier.fillMaxSize()
          )
     }


}

@Preview
@Composable
fun PreviewSplash() {
     SplashScreen()
}
