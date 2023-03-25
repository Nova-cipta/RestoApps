package com.example.restoapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.*
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.restoapps.listmenu.ListMenuScreen
import com.example.restoapps.ui.theme.RestoAppsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            RestoAppsTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "list_menu_screen"
                ) {
                    composable("list_menu_screen") {
                        ListMenuScreen(navController = navController)
                    }
                }
            }
        }
    }
}