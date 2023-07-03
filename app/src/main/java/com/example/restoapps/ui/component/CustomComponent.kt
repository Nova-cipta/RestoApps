package com.example.restoapps.ui.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.example.restoapps.ui.navigates.AppDrawer
import com.example.restoapps.ui.navigates.RestoNavAction
import com.example.restoapps.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicBody(
   pageTitle: String,
   navIconBtn: ImageVector,
   navDesc: String,
   navFunc: () -> Unit,
   rightBtn: @Composable RowScope.() -> Unit = {},
   content : @Composable (Modifier) -> Unit
){
   val topAppBarState = rememberTopAppBarState()
   val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(topAppBarState)
   Scaffold(
      topBar = {
         CenterAlignedTopAppBar(
            modifier = Modifier.shadow(elevation = 8.dp),
            title = { Text(pageTitle) },
            scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(topAppBarState),
            navigationIcon = {
               IconButton(onClick = navFunc) {
                  Icon(
                     imageVector = navIconBtn,
                     contentDescription = navDesc,
                  )
               }
            },
            actions = rightBtn,
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
@Composable
fun DrawerBody(
   pageTitle: String,
   currentRoute: String,
   drawerState: DrawerState,
   navigator: RestoNavAction,
   openDrawer: () -> Unit,
   closeDrawer: () -> Unit,
   rightBtn: @Composable RowScope.() -> Unit = {},
   content : @Composable (Modifier) -> Unit
){
   AppDrawer(
      currentRoute = currentRoute,
      drawerState = drawerState,
      closeDrawer = closeDrawer,
      navigator = navigator
   ) {
      BasicBody(
         pageTitle = pageTitle,
         navIconBtn = Icons.Filled.Menu,
         navDesc = "Navigation Drawer Button",
         navFunc = openDrawer,
         rightBtn = rightBtn
      ) {
         content(it)
      }
   }
}
@Composable
fun SimpleCard(
   modifier: Modifier,
   content: @Composable () -> Unit
){
   Card(
      modifier = modifier,
      elevation = CardDefaults.cardElevation(tiny)
   ) {
      content()
   }
}