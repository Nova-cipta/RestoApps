package com.example.restoapps.ui.navigates

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun AppDrawer(
   currentRoute: String,
   modifier: Modifier = Modifier,
   drawerState: DrawerState,
   closeDrawer: () -> Unit,
   navigator: RestoNavAction,
   content: @Composable () -> Unit
) {
   ModalNavigationDrawer(
      drawerContent = {
         ModalDrawerSheet(modifier) {
            CustomHeader()
            NavigationDrawerItem(
               label = { Text("Home") },
               icon = { Icon(Icons.Filled.Home, null) },
               selected = currentRoute == RestoDestinations.HOME_SCREEN,
               onClick = { navigator.navigateToHome(); closeDrawer() },
               modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )
            NavigationDrawerItem(
               label = { Text("Cashier") },
               icon = { Icon(Icons.Filled.ShoppingCart, null) },
               selected = currentRoute == RestoDestinations.CASHIER_SCREEN,
               onClick = { navigator.navigateToCashier(); closeDrawer() },
               modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )
            NavigationDrawerItem(
               label = { Text("Menu") },
               icon = { Icon(Icons.Filled.List, null) },
               selected = currentRoute == RestoDestinations.MENU_SCREEN,
               onClick = { navigator.navigateToMenu(); closeDrawer() },
               modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )
         }
      },
      drawerState = drawerState,
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