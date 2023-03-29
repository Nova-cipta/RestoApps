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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.restoapps.ui.theme.RestoAppsTheme

@Composable
fun AppDrawer(
    currentRoute: String,
    navigateToHome: () -> Unit,
    navigateToCashier: () -> Unit,
    navigateToMenu: () -> Unit,
    closeDrawer: () -> Unit,
    modifier: Modifier = Modifier
) {
    ModalDrawerSheet(modifier) {
        CustomHeader()
        NavigationDrawerItem(
            label = { Text("Home") },
            icon = { Icon(Icons.Filled.Home, null) },
            selected = currentRoute == RestoDestinations.HOME_SCREEN,
            onClick = { navigateToHome(); closeDrawer() },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )
        NavigationDrawerItem(
            label = { Text("Cashier") },
            icon = { Icon(Icons.Filled.ShoppingCart, null) },
            selected = currentRoute == RestoDestinations.CASHIER_SCREEN,
            onClick = { navigateToCashier(); closeDrawer() },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )
        NavigationDrawerItem(
            label = { Text("Menu") },
            icon = { Icon(Icons.Filled.List, null) },
            selected = currentRoute == RestoDestinations.MENU_SCREEN,
            onClick = { navigateToMenu(); closeDrawer() },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )
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

@Preview("Drawer contents")
@Preview("Drawer contents (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewAppDrawer() {
    RestoAppsTheme() {
        AppDrawer(
            currentRoute = RestoDestinations.HOME_SCREEN,
            navigateToHome = {},
            navigateToCashier = {},
            navigateToMenu = {},
            closeDrawer = { }
        )
    }
}