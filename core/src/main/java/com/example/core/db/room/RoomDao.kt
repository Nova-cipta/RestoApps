package com.example.core.db.room

import androidx.room.*
import com.example.core.db.room.entity.MenuEntity
import com.example.core.db.room.entity.MenuTypeEntity
import com.example.core.db.room.entity.OrderEntity
import com.example.core.db.room.entity.TransactionEntity
import com.example.core.db.room.entity.relation.OrderAndMenuEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomDao {
    @Query("SELECT * FROM menuEntity")
    fun getAllMenu(): Flow<List<MenuEntity>>

    @Query("SELECT * FROM menuEntity WHERE idType = :idType AND available = 1")
    fun getListMenuByType(idType: Long): Flow<List<MenuEntity>>

    @Query("SELECT * FROM menuTypeEntity")
    fun getMenuType(): Flow<List<MenuTypeEntity>>

    @Query("SELECT * FROM orderEntity INNER JOIN menuEntity " +
            "ON orderEntity.idMenu = menuEntity.idMenu " +
            "WHERE idTrans = :idTrans")
    fun getOrderMenuByTrans(idTrans: Long): Flow<List<OrderAndMenuEntity>>

    @Query("SELECT * FROM transactionEntity WHERE isDone = 0")
    fun getOnGoingTrans(): Flow<List<TransactionEntity>>

    @Query("SELECT * FROM transactionEntity WHERE isDone = 1")
    fun getFinishedTrans(): Flow<List<TransactionEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMenu(menuEntity: MenuEntity)

    @Update
    suspend fun updateMenu(menuEntity: MenuEntity)

    @Delete
    suspend fun deleteMenu(menuEntity: MenuEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMenuType(menuTypeEntity: MenuTypeEntity)

    @Update
    suspend fun updateMenuType(menuTypeEntity: MenuTypeEntity)

    @Delete
    suspend fun deleteMenuType(menuTypeEntity: MenuTypeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(orderEntity: OrderEntity)

    @Update
    suspend fun updateOrder(orderEntity: OrderEntity)

    @Delete
    suspend fun deleteOrder(orderEntity: OrderEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrans(transactionEntity: TransactionEntity)

    @Update
    suspend fun updateTrans(transactionEntity: TransactionEntity)

    @Delete
    suspend fun deleteTrans(transactionEntity: TransactionEntity)
}