package com.example.restoapps.ui.menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.core.model.MenuModel
import com.example.restoapps.R
import com.example.restoapps.ui.component.DrawerBody
import com.example.restoapps.ui.component.SimpleCard
import com.example.restoapps.ui.menu.viewmodel.MenuViewModel
import com.example.restoapps.ui.navigates.RestoNavAction
import com.example.restoapps.ui.theme.*

@Composable
fun MenuScreen(
   viewModel: MenuViewModel = hiltViewModel(),
   currentRoute: String,
   drawerState: DrawerState,
   navigator: RestoNavAction,
   openDrawer: () -> Unit,
   closeDrawer: () -> Unit
){
   val data = viewModel.listMenu.collectAsState(initial = emptyList()).value
   DrawerBody(
      pageTitle = "Menu",
      currentRoute = currentRoute,
      drawerState = drawerState,
      navigator = navigator,
      closeDrawer = { closeDrawer() },
      openDrawer = { openDrawer() },
      rightBtn = {
         IconButton( onClick = { navigator.navigateToEdtMenu(null) } ) {
            Icon(
               imageVector = Icons.Filled.Add,
               contentDescription = "Go to Add Menu Page",
            )
         }
      }
   ) {
      Column(modifier = it) {
         if(data.isNotEmpty()) {
            LazyColumn(
               modifier = Modifier.fillMaxWidth(),
               state = rememberLazyListState(),
               content = {
                  items( data.size ) { index ->
                     MenuCardView(data = data[index]){
                        navigator.navigateToEdtMenu(data[index])
                     }
                  }
               }
            )
         }else{
            Column(modifier = it) {
               Text(text = "Data is empty")
            }
         }
      }
   }
}

@Composable
fun MenuCardView(
   data: MenuModel,
   onClick: () -> Unit ={}
) {
   SimpleCard(
      modifier = Modifier.padding(sml).clickable { onClick() }
   ) {
      Column(
         modifier = Modifier.padding(sml),
         verticalArrangement = Arrangement.Top
      ) {
         AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
               .fallback(R.drawable.round_fastfood_24)
               .error(R.drawable.baseline_error_24)
               .data(data.menuImg)
               .build(),
            contentDescription = "menu image",
            modifier = Modifier
               .defaultMinSize(minHeight = 200.dp)
               .fillMaxWidth()
         )
         Text(text = data.menuName)
         Text(text = data.price.toString())
         Text(text = data.available.toString())
      }
   }
}

@Preview
@Composable
fun PreviewCard(){
   LazyColumn(
      modifier = Modifier
         .fillMaxHeight()
         .fillMaxWidth()
   ) {
      items(4) {
         MenuCardView(
            data = MenuModel(
               idMenu = 1,
               idType = 1,
               menuName = "Tes Tes Tes Tes Tes",
               menuImg = " Tes ",
               price = 10.00,
               available = true
            )
         )
      }
   }
}