package com.example.core.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OrderModel(
    var idOrder:Long,
    var idTrans: Long,
    var idMenu: Long,
    var qty: Int,
    var total: Long
):Parcelable
