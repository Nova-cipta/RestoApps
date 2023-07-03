package com.example.restoapps.ui.menu.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.db.IRepository
import com.example.core.model.MenuModel
import com.example.core.model.MenuTypeModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(private val repo: IRepository) : ViewModel() {
   val listMenu = repo.getAllMenu()

   fun populateDummyType(){
      viewModelScope.launch {
         for(i in 0..5) {
            repo.insertMenuType(menuType = MenuTypeModel(0, "Type$i")) {
               println("insertMenuType $it");
            }
         }
      }
   }

   fun insertMenu(name: String, img: String, price: Double, type: Long = 1) = viewModelScope.launch {
      repo.insertMenu( MenuModel( 0, type, name, img, price, true, )){
         println("Insert $name ${ if(it) "Success" else "Failed" } ")
      }
   }

   fun deleteData(menu: MenuModel) = viewModelScope.launch {
      repo.deleteMenu(menu){ println("Delete ${menu.menuName} $it") }
   }
}