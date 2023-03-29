package com.example.restoapps.ui.navigates

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.restoapps.ui.cashier.CashierScreen
import com.example.restoapps.ui.home.HomeScreen
import com.example.restoapps.ui.menu.DetailMenuScreen
import com.example.restoapps.ui.menu.MenuScreen

@Composable
fun RestoNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = RestoDestinations.HOME_SCREEN
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(RestoDestinations.HOME_SCREEN) {
            HomeScreen(navController = navController)
        }
        composable(RestoDestinations.CASHIER_SCREEN) {
            CashierScreen(navController = navController)
        }
        composable(RestoDestinations.MENU_SCREEN){
            MenuScreen(navController = navController)
        }
    }
}