package com.example.restoapps.ui.navigates

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.example.core.model.MenuModel
import com.example.restoapps.ui.cashier.CashierScreen
import com.example.restoapps.ui.home.HomeScreen
import com.example.restoapps.ui.menu.DetailMenuScreen
import com.example.restoapps.ui.menu.MenuScreen
import kotlinx.coroutines.launch

@Composable
fun RestoNavGraph(
   modifier: Modifier = Modifier,
   navController: NavHostController = rememberNavController(),
   startDestination: String = RestoDestinations.HOME_SCREEN
) {
   val navigationActions = remember(navController) {
      RestoNavAction(navController)
   }

   val coroutineScope = rememberCoroutineScope()
   val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

   val navBackStackEntry by navController.currentBackStackEntryAsState()
   val currentRoute = navBackStackEntry?.destination?.route ?: RestoDestinations.HOME_SCREEN

   NavHost(
      navController = navController,
      startDestination = startDestination,
      modifier = modifier
   ) {
      composable(RestoDestinations.HOME_SCREEN) {
         HomeScreen(
            currentRoute = currentRoute,
            drawerState = drawerState,
            navigator = navigationActions,
            closeDrawer = { coroutineScope.launch { drawerState.close() } },
            openDrawer = { coroutineScope.launch { drawerState.open() } }
         )
      }
      composable(RestoDestinations.CASHIER_SCREEN) {
         CashierScreen(
            currentRoute = currentRoute,
            drawerState = drawerState,
            navigator = navigationActions,
            closeDrawer = { coroutineScope.launch { drawerState.close() } },
            openDrawer = { coroutineScope.launch { drawerState.open() } }
         )
      }
      composable(RestoDestinations.MENU_SCREEN){
         MenuScreen(
            currentRoute = currentRoute,
            drawerState = drawerState,
            navigator = navigationActions,
            closeDrawer = { coroutineScope.launch { drawerState.close() } },
            openDrawer = { coroutineScope.launch { drawerState.open() } }
         )
      }
      composable(RestoDestinations.EDT_MENU_SCREEN +
            "/{id}?type={type}?name={name}?img={image}?price={price}?able={bool}",
         deepLinks = listOf( navDeepLink { uriPattern = "id" }, navDeepLink{uriPattern = "type"},
            navDeepLink{uriPattern = "name"}, navDeepLink{uriPattern = "image"},
            navDeepLink{uriPattern = "price"}, navDeepLink{uriPattern = "bool"}
         )
      ){
         val menu = MenuModel(
            idMenu = it.arguments?.getLong("id")?:0L,
            idType = it.arguments?.getLong("type")?:0L,
            menuName = it.arguments?.getString("name")?:"",
            menuImg = it.arguments?.getString("image")?:"",
            price = it.arguments?.getDouble("price")?:0.0,
            available = it.arguments?.getBoolean("bool")?:true,
         )
         DetailMenuScreen( navigator = navigationActions, data = menu )
      }
   }
}