package com.example.core.db.room.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.core.db.room.entity.OrderEntity
import com.example.core.db.room.entity.TransactionEntity

data class TransWithOrderEntity(
    @Embedded
    var transactionEntity: TransactionEntity,

    @Relation(
        parentColumn = "idTrans",
        entityColumn = "idTrans"
    )
    var listOrder: List<OrderEntity>
)
