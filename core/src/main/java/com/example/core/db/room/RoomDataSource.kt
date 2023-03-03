package com.example.core.db.room

import com.example.core.db.room.entity.MenuEntity
import com.example.core.db.room.entity.MenuTypeEntity
import com.example.core.db.room.entity.OrderEntity
import com.example.core.db.room.entity.TransactionEntity
import com.example.core.db.room.entity.relation.OrderAndMenuEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomDataSource @Inject constructor(private val  roomDao: RoomDao) {
    fun getAllMenu(): Flow<List<MenuEntity>> = roomDao.getAllMenu()

    fun getListMenuByType(idType: Long): Flow<List<MenuEntity>> = roomDao.getListMenuByType(idType)

    fun getMenuType(): Flow<List<MenuTypeEntity>> = roomDao.getMenuType()

    fun getOrderMenuByTrans(idTrans: Long): Flow<List<OrderAndMenuEntity>>
        = roomDao.getOrderMenuByTrans(idTrans)

    fun getOnGoingTrans(): Flow<List<TransactionEntity>> = roomDao.getOnGoingTrans()

    fun getFinishedTrans(): Flow<List<TransactionEntity>> = roomDao.getFinishedTrans()

    suspend fun insertMenu(menuEntity: MenuEntity) = roomDao.insertMenu(menuEntity)

    suspend fun updateMenu(menuEntity: MenuEntity) = roomDao.updateMenu(menuEntity)

    suspend fun deleteMenu(menuEntity: MenuEntity) = roomDao.deleteMenu(menuEntity)

    suspend fun insertMenuType(menuTypeEntity: MenuTypeEntity) = roomDao.insertMenuType(menuTypeEntity)

    suspend fun updateMenuType(menuTypeEntity: MenuTypeEntity) = roomDao.insertMenuType(menuTypeEntity)

    suspend fun deleteMenuType(menuTypeEntity: MenuTypeEntity) = roomDao.deleteMenuType(menuTypeEntity)

    suspend fun insertOrder(orderEntity: OrderEntity) = roomDao.insertOrder(orderEntity)

    suspend fun updateOrder(orderEntity: OrderEntity) = roomDao.updateOrder(orderEntity)

    suspend fun deleteOrder(orderEntity: OrderEntity) = roomDao.deleteOrder(orderEntity)

    suspend fun insertTrans(transactionEntity: TransactionEntity)= roomDao.insertTrans(transactionEntity)

    suspend fun updateTrans(transactionEntity: TransactionEntity) = roomDao.updateTrans(transactionEntity)

    suspend fun deleteTrans(transactionEntity: TransactionEntity) = roomDao.deleteTrans(transactionEntity)
}