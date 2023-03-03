package com.example.core.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuModel(
    var idMenu: Long,
    var idType: Long,
    var menuName: String,
    var menuImg: String,
    var price: Double,
    var available: Boolean
):Parcelable
