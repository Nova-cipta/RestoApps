package com.example.restoapps.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.example.restoapps.ui.navigates.*
import com.example.restoapps.ui.theme.RestoAppsTheme
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContent{
         val navController = rememberNavController()
         RestoAppsTheme {
            RestoNavGraph(
               navController = navController
            )
         }
      }
   }
}