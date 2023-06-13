package com.example.restoapps.ui.navigates

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

object RestoDestinations{
   const val HOME_SCREEN = "home_screen"
   const val CASHIER_SCREEN = "cashier_screen"
   const val MENU_SCREEN = "menu_screen"
   const val EDT_MENU_SCREEN ="detail_menu_screen"
}
class RestoNavAction(navController: NavHostController) {
   val navigateToHome: () -> Unit = {
      navController.navigate(RestoDestinations.HOME_SCREEN) {
         // Pop up to the start destination of the graph to
         // avoid building up a large stack of destinations
         // on the back stack as users select items
         popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
         }
         // Avoid multiple copies of the same destination when
         // reselecting the same item
         launchSingleTop = true
         // Restore state when reselecting a previously selected item
         restoreState = true
      }
   }
   val navigateToCashier: () -> Unit = {
      navController.navigate(RestoDestinations.CASHIER_SCREEN) {
         popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
         }
         launchSingleTop = true
         restoreState = true
      }
   }
   val navigateToMenu: () -> Unit = {
      navController.navigate(RestoDestinations.MENU_SCREEN) {
         popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
         }
         launchSingleTop = true
         restoreState = true
      }
   }
   val navigateToEdtMenu: () ->Unit = {
      navController.navigate(RestoDestinations.EDT_MENU_SCREEN) {
         popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
         }
         launchSingleTop = true
         restoreState = true
      }
   }
}