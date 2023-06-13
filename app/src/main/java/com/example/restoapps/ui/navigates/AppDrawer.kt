package com.example.restoapps.ui.navigates

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.restoapps.ui.theme.RestoAppsTheme
import kotlinx.coroutines.launch

@Composable
fun AppDrawer(
   modifier: Modifier = Modifier,
   navController : NavHostController = rememberNavController(),
   drawerState: DrawerState,
   closeDrawer: () -> Unit,
   content: @Composable () -> Unit
) {
   val navigationActions = remember(navController) {
      RestoNavAction(navController)
   }

   val navBackStackEntry by navController.currentBackStackEntryAsState()
   val currentRoute = navBackStackEntry?.destination?.route ?: RestoDestinations.HOME_SCREEN

   ModalNavigationDrawer(
      drawerContent = {
         ModalDrawerSheet(modifier) {
            CustomHeader()
            NavigationDrawerItem(
               label = { Text("Home") },
               icon = { Icon(Icons.Filled.Home, null) },
               selected = currentRoute == RestoDestinations.HOME_SCREEN,
               onClick = { navigationActions.navigateToHome(); closeDrawer() },
               modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )
            NavigationDrawerItem(
               label = { Text("Cashier") },
               icon = { Icon(Icons.Filled.ShoppingCart, null) },
               selected = currentRoute == RestoDestinations.CASHIER_SCREEN,
               onClick = { navigationActions.navigateToCashier(); closeDrawer() },
               modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )
            NavigationDrawerItem(
               label = { Text("Menu") },
               icon = { Icon(Icons.Filled.List, null) },
               selected = currentRoute == RestoDestinations.MENU_SCREEN,
               onClick = { navigationActions.navigateToMenu(); closeDrawer() },
               modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )
         }
      },//move to app drawer
      drawerState = drawerState,//move to app drawer
      gesturesEnabled = true
   ) {
      content()
   }
}

@Composable
private fun CustomHeader() {
   Row(modifier = Modifier.padding(horizontal = 28.dp, vertical = 24.dp)) {
      Icon(
         imageVector = Icons.Filled.Menu,
         contentDescription = null,
         tint = MaterialTheme.colorScheme.primary
      )
      Spacer(Modifier.width(8.dp))
      Text(text = "Sample Drawer", textAlign = TextAlign.Center)
   }
}

//@Preview("Drawer contents")
//@Preview("Drawer contents (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Composable
//fun PreviewAppDrawer() {
//   RestoAppsTheme() {
//      AppDrawer(
//         currentRoute = RestoDestinations.HOME_SCREEN,
//         navigateToHome = {},
//         navigateToCashier = {},
//         navigateToMenu = {},
//         closeDrawer = { }
//      )
//   }
//}