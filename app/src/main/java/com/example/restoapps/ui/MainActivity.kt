package com.example.restoapps.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Surface
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
import com.example.restoapps.ui.navigates.RestoNavGraph
import com.example.restoapps.ui.theme.RestoAppsTheme
import com.example.restoapps.ui.theme.md_theme_dark_inversePrimary
import com.example.restoapps.ui.theme.md_theme_light_onPrimary
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContent{
         val navController = rememberNavController()
         RestoAppsTheme {
            Surface(
               tonalElevation = 1.dp,
               color = md_theme_light_onPrimary,
               contentColor = md_theme_dark_inversePrimary
            ) {
               RestoNavGraph(
                  navController = navController
               )
            }
         }
      }
   }
}