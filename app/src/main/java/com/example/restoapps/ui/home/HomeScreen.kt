package com.example.restoapps.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.restoapps.R
import com.example.restoapps.ui.component.DrawerBody
import com.example.restoapps.ui.component.Graph
import com.example.restoapps.ui.navigates.RestoNavAction
import com.example.restoapps.ui.theme.*
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun HomeScreen(
   currentRoute: String,
   drawerState: DrawerState,
   navigator: RestoNavAction,
   openDrawer: () -> Unit,
   closeDrawer: () -> Unit
){
   DrawerBody(
      pageTitle = "Home",
      currentRoute = currentRoute,
      drawerState = drawerState,
      navigator = navigator,
      closeDrawer = { closeDrawer() },
      openDrawer = { openDrawer() },
   ) {
      LazyColumn(
         modifier = it,
         state = rememberLazyListState(),
         userScrollEnabled = true,
      ) {
         val homeModifier = Modifier.padding(horizontal = sml)
         item { TodayStats(homeModifier) { navigator.navigateToCashier() } }
         item { StatsCompare(modifier = homeModifier) }
         item { StatsGrid(modifier = homeModifier) }
         item { MonthlySales(modifier = homeModifier) }
         item { BestSellingItem(modifier = homeModifier) }
         items(5){index ->
            Card(
               modifier = homeModifier
                  .padding(sml)
                  .fillMaxWidth(),
               elevation = CardDefaults.cardElevation(tiny)
            ) {
               Text(modifier = Modifier.padding(sml),text = "menu item $index")
            }
         }
      }
   }
}
@Composable
fun TodayStats(modifier: Modifier, onClick: () -> Unit = {}){
   val format = "EEEE, dd MMM yyyy"
   val date = SimpleDateFormat(format, Locale.getDefault()).format(Date().time)
   Row(modifier = modifier.padding(nol, std, nol, sml)) {
      Card(
         modifier = modifier.height(med).weight(1f),
         elevation = CardDefaults.cardElevation(tiny)
      ) {
         Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
         ) {
            Text(modifier = modifier, text = "Date: $date")
         }
      }
      Card(
         modifier = modifier.width(big).height(med).clickable { onClick() },
         elevation = CardDefaults.cardElevation(tiny)
      ) {
         Row(
            modifier = modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
         ) {
            Icon(
               painter = painterResource(id = R.drawable.baseline_shopping_cart_24),
               contentDescription = "Leading Icon"
            )
            Icon(
               painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
               contentDescription = "Trailing Icon"
            )
         }
      }
   }
}
@Composable
fun StatsGrid(modifier: Modifier){
   Row(
      modifier = modifier.padding(vertical = sml).fillMaxWidth().height(large)
   ) {
      Card(
         modifier = modifier.fillMaxHeight().weight(1f),
         elevation = CardDefaults.cardElevation(tiny)
      ) {
         Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
         ) {
            Text(
               text = "Transaction Value",
               textAlign = TextAlign.Center,
               maxLines = 2,
            )
            Text(
               text = "19.2 Mil",
               textAlign = TextAlign.Center,
               fontWeight = FontWeight.Bold,
               fontSize = 24.sp,
               maxLines = 2,
            )
         }
      }
      Card(
         modifier = modifier.fillMaxHeight().weight(1f),
         elevation = CardDefaults.cardElevation(tiny)
      ) {
         Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
         ) {
            Text(
               text = "Total Transaction",
               textAlign = TextAlign.Center,
               maxLines = 2,
            )
            Text(
               text = "168",
               textAlign = TextAlign.Center,
               fontWeight = FontWeight.Bold,
               fontSize = 24.sp,
               maxLines = 1,
            )
         }
      }
      Card(
         modifier = modifier.fillMaxHeight().weight(1f),
         elevation = CardDefaults.cardElevation(tiny)
      ) {
         Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
         ) {
            Text(
               modifier = modifier,
               text = "Estimated Profit",
               textAlign = TextAlign.Center,
               maxLines = 2,
            )
            Text(
               text = "1.500K",
               textAlign = TextAlign.Center,
               fontWeight = FontWeight.Bold,
               fontSize = 24.sp,
               maxLines = 1,
            )
         }
      }
   }
}
@Composable
fun StatsCompare(modifier: Modifier){
   Card(
      modifier = modifier.padding(sml).fillMaxWidth().height(big),
      elevation = CardDefaults.cardElevation(tiny)
   ) {
      Column(
         modifier = modifier.fillMaxHeight(),
         verticalArrangement = Arrangement.SpaceEvenly,
      ) {
         Text(
            modifier = modifier.fillMaxWidth(),
            text = "Today's Sales 28% higher than yesterday",
            textAlign = TextAlign.Justify
         )
         LinearProgressIndicator(
            modifier = modifier.fillMaxWidth().height(std),
            strokeCap = StrokeCap.Round,
            color = md_theme_light_tertiaryContainer,
            trackColor = md_theme_light_tertiary,
            progress = fHug,
         )
      }
   }
}
@Composable
fun MonthlySales(modifier: Modifier){
   val xVal = listOf("May", "Jun", "Jul", "Aug")
   val points = listOf(0.5f,2f,2.5f,3.5f)
   Card(
      modifier = modifier.padding(sml).fillMaxSize(),
      elevation = CardDefaults.cardElevation(tiny)
   ) {
      Column(
         horizontalAlignment = Alignment.CenterHorizontally
      ) {
         Graph(
            modifier = modifier.padding(sml).fillMaxWidth().height(480.dp),
            title = "Monthly Sales",
            xValues = xVal,
            data = points
         )
      }
   }
}
@Composable
fun BestSellingItem(modifier: Modifier, onClick: () -> Unit = {}){
   Card(
      modifier = modifier.padding(sml).fillMaxWidth().height(med),
      elevation = CardDefaults.cardElevation(tiny)
   ) {
      Row(
         modifier = modifier.fillMaxSize(),
         verticalAlignment = Alignment.CenterVertically,
         horizontalArrangement = Arrangement.SpaceBetween
      ) {
         Text(modifier = modifier, text = "Best Selling Items")
         IconButton(
            modifier = Modifier.width(big).fillMaxHeight(),
            onClick = { onClick() }
         ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
               Text(modifier = modifier, text = "See All")
               Icon(
                  painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                  contentDescription = "Trailing Icon"
               )
            }
         }
      }
   }
}
@Preview
@Composable
fun HomePreview(){
   Scaffold {
      val modifier = Modifier.padding(it).fillMaxSize()
      LazyColumn(
         modifier = modifier,
         state = rememberLazyListState(),
         userScrollEnabled = true,
      ) {
         val homeModifier = Modifier.padding(horizontal = sml)
         item { TodayStats(modifier = homeModifier) }
         item { StatsCompare(modifier = homeModifier) }
         item { StatsGrid(modifier = homeModifier) }
         item { MonthlySales(modifier = homeModifier) }
         item { BestSellingItem(modifier = homeModifier) }
         items(5){index ->
            Card(
               modifier = homeModifier.padding(sml).fillMaxWidth(),
               elevation = CardDefaults.cardElevation(tiny)
            ) {
               Text(modifier = Modifier.padding(sml),text = "menu item $index")
            }
         }
      }
   }
}