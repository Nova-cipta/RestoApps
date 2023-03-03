package com.example.core.db.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orderEntity")
data class OrderEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idOrder")
    var idOrder:Long,

    @ColumnInfo(name = "idTrans")
    var idTrans: Long,

    @ColumnInfo(name = "idMenu")
    var idMenu: Long,

    @ColumnInfo(name = "quantity")
    var qty: Int,

    @ColumnInfo(name = "total")
    var total: Long
)
