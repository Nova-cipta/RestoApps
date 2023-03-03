package com.example.core.db

import com.example.core.db.room.RoomDataSource
import com.example.core.db.room.entity.MenuEntity
import com.example.core.db.room.entity.MenuTypeEntity
import com.example.core.db.room.entity.OrderEntity
import com.example.core.db.room.entity.TransactionEntity
import com.example.core.db.room.entity.relation.OrderAndMenuEntity
import com.example.core.dispatcher.DispatcherProvider
import com.example.core.dispatcher.StandardDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val roomDataSource: RoomDataSource,
    private val dispatcher: DispatcherProvider
): IRepository {
    override fun getAllMenu(): Flow<List<MenuEntity>> {
        TODO("Not yet implemented")
    }

    override fun getListMenuByType(idType: Long): Flow<List<MenuEntity>> {
        TODO("Not yet implemented")
    }

    override fun getMenuType(): Flow<List<MenuTypeEntity>> {
        TODO("Not yet implemented")
    }

    override fun getOrderMenuByTrans(idTrans: Long): Flow<List<OrderAndMenuEntity>> {
        TODO("Not yet implemented")
    }

    override fun getOnGoingTrans(): Flow<List<TransactionEntity>> {
        TODO("Not yet implemented")
    }

    override fun getFinishedTrans(): Flow<List<TransactionEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertMenu(menuEntity: MenuEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun updateMenu(menuEntity: MenuEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMenu(menuEntity: MenuEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun insertMenuType(menuTypeEntity: MenuTypeEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun updateMenuType(menuTypeEntity: MenuTypeEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMenuType(menuTypeEntity: MenuTypeEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun insertOrder(orderEntity: OrderEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun updateOrder(orderEntity: OrderEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteOrder(orderEntity: OrderEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun insertTrans(transactionEntity: TransactionEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun updateTrans(transactionEntity: TransactionEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTrans(transactionEntity: TransactionEntity) {
        TODO("Not yet implemented")
    }
}