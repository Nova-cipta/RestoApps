package com.example.restoapps.ui.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.restoapps.ui.navigates.RestoDestinations

@Composable
fun MenuScreen(
    navController: NavController
){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Menu")
        Button(
            onClick = {},
        ) {
            Text(text = "To EDT Menu")
        }
    }
}