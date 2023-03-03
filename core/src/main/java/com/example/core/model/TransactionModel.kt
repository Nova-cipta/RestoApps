package com.example.core.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TransactionModel(
    var idTrans: Long,
    var table: Int,
    var date: Long,
    var total: Long,
    var tax: Long,
    var tip: Long,
    var isDone: Boolean
):Parcelable
