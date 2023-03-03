package com.example.core.db.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "menuEntity")
data class MenuEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idMenu")
    var idMenu: Long,

    @ColumnInfo(name = "idType")
    var idType: Long,

    @ColumnInfo(name = "menuName")
    var menuName: String,

    @ColumnInfo(name = "menuImg")
    var menuImg: String,

    @ColumnInfo(name = "price")
    var price: Double,

    @ColumnInfo(name = "available")
    var available: Boolean = true
)
