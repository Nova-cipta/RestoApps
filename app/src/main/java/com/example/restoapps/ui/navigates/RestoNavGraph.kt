package com.example.restoapps.ui.navigates

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
   NavHost(
      navController = navController,
      startDestination = startDestination,
      modifier = modifier
   ) {
      composable(RestoDestinations.HOME_SCREEN) {
         DrawerBody(
            pageTitle = "Home",
            navController = navController
         ) {
            HomeScreen(modifier = it, navController = navController)
         }
      }
      composable(RestoDestinations.CASHIER_SCREEN) {
         DrawerBody(
            pageTitle = "Cashier",
            navController = navController
         ) {
            CashierScreen(modifier = it, navController = navController)
         }
      }
      composable(RestoDestinations.MENU_SCREEN){
         DrawerBody(
            pageTitle = "Menu",
            navController = navController
         ) {
            MenuScreen(modifier = it, navController = navController)
         }
      }
      composable(RestoDestinations.EDT_MENU_SCREEN){
         val navigationActions = remember(navController) {
            RestoNavAction(navController)
         }
         BasicBody(
            pageTitle = "Detail Menu",
            iconLeftDesc = "Back Button",
            iconLeft = Icons.Filled.ArrowBack,
            iconLeftFun = navigationActions.navigateToMenu
         ) {
            DetailMenuScreen(
               modifier = it,
               navController = navController
            )
         }
      }
   }
}
@Composable
fun DrawerBody(
   pageTitle: String,
   navController : NavHostController = rememberNavController(),
   content : @Composable (Modifier) -> Unit
){
   val coroutineScope = rememberCoroutineScope()
   val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
   AppDrawer(
      navController = navController,
      drawerState = drawerState,
      closeDrawer = { coroutineScope.launch { drawerState.close() } }
   ) {
      BasicBody(
         pageTitle = pageTitle,
         iconLeft = Icons.Filled.Menu,
         iconLeftDesc = "Navigation Drawer Button",
         iconLeftFun = { coroutineScope.launch { drawerState.open() } }
      ) {
         content(it)
      }
   }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicBody(
   pageTitle: String,
   iconLeft: ImageVector,
   iconLeftDesc: String,
   iconLeftFun: () -> Unit,
   content : @Composable (Modifier) -> Unit
){
   val topAppBarState = rememberTopAppBarState()
   val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(topAppBarState)
   Scaffold(
      topBar = {
         CenterAlignedTopAppBar(
            title = { Text(pageTitle) },
            scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(topAppBarState),
            navigationIcon = {
               IconButton(onClick = iconLeftFun) {
                  Icon(
                     imageVector = iconLeft,
                     contentDescription = iconLeftDesc,
                  )
               }
            }
         )
      }
   ) { innerPadding ->
      val contentModifier = Modifier
         .padding(innerPadding)
         .nestedScroll(scrollBehavior.nestedScrollConnection)
         .fillMaxSize()
      content(contentModifier)
   }
}