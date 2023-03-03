package com.example.core.db.room.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.core.db.room.entity.MenuEntity
import com.example.core.db.room.entity.OrderEntity

data class MenuWithOrderEntity(
    @Embedded
    var menuEntity: MenuEntity,
    @Relation(
        parentColumn = "idMenu",
        entityColumn = "idMenu"
    )
    var orderEntity: List<OrderEntity>
)
