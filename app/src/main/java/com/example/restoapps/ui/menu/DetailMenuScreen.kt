package com.example.restoapps.ui.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.restoapps.ui.navigates.RestoNavAction

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailMenuScreen(
   modifier: Modifier,
   navController: NavHostController
){
   Column(
      modifier = modifier
   ) {
      Text(text = "Detail Menu")
   }
}
