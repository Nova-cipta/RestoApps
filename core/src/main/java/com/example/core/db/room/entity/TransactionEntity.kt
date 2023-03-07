package com.example.core.db.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactionEntity")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idTrans")
    var idTrans: Long,

    @ColumnInfo(name = "table")
    var table: Int,

    @ColumnInfo(name = "date")
    var date: Long,

    @ColumnInfo(name = "total")
    var total: Long,

    @ColumnInfo(name = "tax")
    var tax: Long,

    @ColumnInfo(name = "tip")
    var tip: Long,

    @ColumnInfo(name = "isDone")
    var isDone: Boolean = false
)
