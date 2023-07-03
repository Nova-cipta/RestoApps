package com.example.restoapps.ui.menu

import android.Manifest
import android.os.Environment
import android.provider.OpenableColumns
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.core.model.MenuModel
import com.example.restoapps.R
import com.example.restoapps.ui.component.BasicBody
import com.example.restoapps.ui.component.SimpleCard
import com.example.restoapps.ui.menu.viewmodel.MenuViewModel
import com.example.restoapps.ui.navigates.RestoNavAction
import com.example.restoapps.ui.theme.*
import okio.Path.Companion.toPath

@Composable
fun DetailMenuScreen(
   data: MenuModel,
   viewModel: MenuViewModel = hiltViewModel(),
   navigator: RestoNavAction
){
   val readContracts = ActivityResultContracts.RequestPermission()
   val pickImgContracts = ActivityResultContracts.GetContent()

   val context = LocalContext.current
   val childModifier = Modifier
      .padding(sml)
      .fillMaxWidth()

   var typeIdText by rememberSaveable{ mutableStateOf(data.idType) }
   var nameText by rememberSaveable{
      mutableStateOf( if(data.menuName == "null") "" else data.menuName )
   }
   var imgSrc by rememberSaveable {
      mutableStateOf( if(data.menuImg == "null") null else data.menuImg )
   }
   var priceText by rememberSaveable{ mutableStateOf(data.price) }

   val pickImage = rememberLauncherForActivityResult( pickImgContracts ){ uri ->
      uri?.let {
         context.contentResolver.query(it, null, null, null, null)
      }?.use { cursor ->
         val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
         cursor.moveToFirst()
         val imgName = cursor.getString(nameIndex)
         val picDir = Environment.DIRECTORY_PICTURES.toPath()
         val extDir = Environment.getExternalStorageDirectory().path
         cursor.close()
         imgSrc = "$extDir/$picDir/$imgName"
      }
   }

   val reqPermisions = rememberLauncherForActivityResult( readContracts ) { isGranted ->
      if (isGranted) {
         pickImage.launch( "image/*" )
      } else {
         //
      }
   }

   BasicBody(
      pageTitle = if (data.idMenu == 0L) "Add Menu" else "Detail Menu",
      navIconBtn = Icons.Filled.ArrowBack,
      navDesc = "Back Button",
      navFunc = { navigator.navigateBack() },
   ) {
      Column(
         modifier = it
            .padding(sml)
            .verticalScroll(rememberScrollState()),
         horizontalAlignment = Alignment.End,
      ) {
         SimpleCard(
            modifier = childModifier.height(300.dp)
         ) {
            AsyncImage(
               model = ImageRequest.Builder(LocalContext.current)
                  .fallback(R.drawable.round_fastfood_24)
                  .error(R.drawable.baseline_error_24)
                  .data(imgSrc)
                  .build(),
               contentDescription = "Image Container",
               alignment = Alignment.Center,
               modifier = childModifier
                  .fillMaxHeight()
                  .clickable { reqPermisions.launch(Manifest.permission.READ_EXTERNAL_STORAGE) }
            )
         }
         SimpleCard( childModifier ) {
            Column(childModifier) {
               TextField(
                  modifier = childModifier,
                  value = nameText,
                  onValueChange = { result -> nameText = result }
               )
               TextField(
                  modifier = childModifier,
                  enabled = false,
                  value = "Food and Beverage",
                  onValueChange = {  }
               )
               TextField(
                  modifier = childModifier,
                  value = priceText.toString(),
                  onValueChange = { result -> priceText = result.toDouble() }
               )
            }
         }
         Button(
            modifier = Modifier.width(150.dp),
            onClick = { viewModel.insertMenu(nameText, imgSrc.toString(), priceText) }
         ) {
            Text(text = "Test")
         }
      }
   }
}