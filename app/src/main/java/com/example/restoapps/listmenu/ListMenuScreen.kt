package com.example.restoapps.listmenu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun ListMenuScreen(
    navController: NavController,
    viewModel: ListMenuViewModel = hiltViewModel()
){
    val menuListed by viewModel.menuLists().collectAsState(initial = emptyList())
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            menuListed.forEach {
                Text(text = it.menuName)
            }
            Button(
                onClick = { viewModel.insertMenu() }
            ){
                Text(text = "Add Menu")
            }
        }
    }
}