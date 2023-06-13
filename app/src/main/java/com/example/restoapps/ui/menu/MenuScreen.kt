package com.example.restoapps.ui.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.restoapps.ui.navigates.RestoNavAction

@Composable
fun MenuScreen(
   modifier: Modifier,
   navController: NavHostController = rememberNavController(),
){
   val navigationActions = remember(navController) {
      RestoNavAction(navController)
   }
   Column(
      modifier = modifier,
   ) {
      Text(text = "Menu")
      Button(
         onClick = {
            navigationActions.navigateToEdtMenu()
         },
      ) {
         Text(text = "To EDT Menu")
      }
   }
}