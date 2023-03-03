package com.example.core.db

import com.example.core.db.room.entity.MenuEntity
import com.example.core.db.room.entity.MenuTypeEntity
import com.example.core.db.room.entity.OrderEntity
import com.example.core.db.room.entity.TransactionEntity
import com.example.core.db.room.entity.relation.OrderAndMenuEntity
import kotlinx.coroutines.flow.Flow

interface IRepository {

    fun getAllMenu(): Flow<List<MenuEntity>>

    fun getListMenuByType(idType: Long): Flow<List<MenuEntity>>

    fun getMenuType(): Flow<List<MenuTypeEntity>>

    fun getOrderMenuByTrans(idTrans: Long): Flow<List<OrderAndMenuEntity>>

    fun getOnGoingTrans(): Flow<List<TransactionEntity>>

    fun getFinishedTrans(): Flow<List<TransactionEntity>>

    suspend fun insertMenu(menuEntity: MenuEntity)

    suspend fun updateMenu(menuEntity: MenuEntity)

    suspend fun deleteMenu(menuEntity: MenuEntity)

    suspend fun insertMenuType(menuTypeEntity: MenuTypeEntity)

    suspend fun updateMenuType(menuTypeEntity: MenuTypeEntity)

    suspend fun deleteMenuType(menuTypeEntity: MenuTypeEntity)

    suspend fun insertOrder(orderEntity: OrderEntity)

    suspend fun updateOrder(orderEntity: OrderEntity)

    suspend fun deleteOrder(orderEntity: OrderEntity)

    suspend fun insertTrans(transactionEntity: TransactionEntity)

    suspend fun updateTrans(transactionEntity: TransactionEntity)

    suspend fun deleteTrans(transactionEntity: TransactionEntity)
}