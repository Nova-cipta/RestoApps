package com.example.restoapps.listmenu

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.db.IRepository
import com.example.core.model.MenuModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListMenuViewModel @Inject constructor(
    private val iRepository: IRepository
): ViewModel(), LifecycleObserver {

    fun menuLists() = iRepository.getAllMenu()

    fun insertMenu(){
        viewModelScope.launch {
            iRepository.insertMenu(
                MenuModel(
                    idMenu = 0,
                    idType = 1,
                    menuName = "Menu1",
                    menuImg = "-",
                    price = 100.000,
                    available = true
                ),::doNothing
            )
        }
    }
    fun doNothing(boolean: Boolean){}
}