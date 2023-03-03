package com.example.core.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.db.room.entity.MenuEntity
import com.example.core.db.room.entity.MenuTypeEntity
import com.example.core.db.room.entity.OrderEntity
import com.example.core.db.room.entity.TransactionEntity

@Database(
    entities = [
        MenuEntity::class,
        MenuTypeEntity::class,
        OrderEntity::class,
        TransactionEntity::class,
    ],
    exportSchema = false,
    version = 1
)
abstract class RoomDb: RoomDatabase() {
    abstract fun  roomDao(): RoomDao
}