package com.example.restoapps.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun HomeScreen(
   modifier: Modifier,
   navController: NavController
){
   Column(
      modifier = modifier
   ) {
      Text(text = "Home")
   }
}