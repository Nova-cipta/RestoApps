package com.example.core.db

import com.example.core.db.room.entity.MenuEntity
import com.example.core.db.room.entity.MenuTypeEntity
import com.example.core.db.room.entity.OrderEntity
import com.example.core.db.room.entity.TransactionEntity
import com.example.core.db.room.entity.relation.OrderAndMenuEntity
import com.example.core.model.*
import kotlinx.coroutines.flow.Flow

interface IRepository {
    fun getAllMenu(): Flow<List<MenuModel>>

    fun getListMenuByType(idType: Long): Flow<List<MenuModel>>

    fun getMenuType(): Flow<List<MenuTypeModel>>

    fun getOrderMenuByTrans(idTrans: Long): Flow<List<OrderAndMenu>>

    fun getOnGoingTrans(): Flow<List<TransactionModel>>

    fun getFinishedTrans(): Flow<List<TransactionModel>>

    suspend fun insertMenu(menu: MenuModel, result: (Boolean) -> Unit)

    suspend fun updateMenu(menu: MenuModel, result: (Boolean) -> Unit)

    suspend fun deleteMenu(menu: MenuModel, result: (Boolean) -> Unit)

    suspend fun insertMenuType(menuType: MenuTypeModel, result: (Boolean) -> Unit)

    suspend fun updateMenuType(menuType: MenuTypeModel, result: (Boolean) -> Unit)

    suspend fun deleteMenuType(menuType: MenuTypeModel, result: (Boolean) -> Unit)

    suspend fun insertOrder(orderModel: OrderModel, result: (Boolean) -> Unit)

    suspend fun updateOrder(orderModel: OrderModel, result: (Boolean) -> Unit)

    suspend fun deleteOrder(orderModel: OrderModel, result: (Boolean) -> Unit)

    suspend fun insertTrans(transModel: TransactionModel, result: (Boolean) -> Unit)

    suspend fun updateTrans(transModel: TransactionModel, result: (Boolean) -> Unit)

    suspend fun deleteTrans(transModel: TransactionModel, result: (Boolean) -> Unit)
}