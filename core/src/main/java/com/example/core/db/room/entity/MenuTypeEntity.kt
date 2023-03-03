package com.example.core.db.room.entity

import androidx.room.*

@Entity(tableName = "menuTypeEntity")
data class MenuTypeEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idType")
    var idType: Long,

    @ColumnInfo(name = "type")
    var type: String
)
