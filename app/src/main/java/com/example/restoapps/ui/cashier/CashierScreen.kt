package com.example.restoapps.ui.cashier

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.restoapps.ui.component.DrawerBody
import com.example.restoapps.ui.navigates.RestoNavAction

@Composable
fun CashierScreen(
   currentRoute: String,
   drawerState: DrawerState,
   navigator: RestoNavAction,
   openDrawer: () -> Unit,
   closeDrawer: () -> Unit
){
   DrawerBody(
      pageTitle = "Cashier",
      currentRoute = currentRoute,
      drawerState = drawerState,
      navigator = navigator,
      closeDrawer = { closeDrawer() },
      openDrawer = { openDrawer() },
   ) {
      Column(
         modifier = it,
      ) {
         Text(text = "Cashier")
      }
   }
}