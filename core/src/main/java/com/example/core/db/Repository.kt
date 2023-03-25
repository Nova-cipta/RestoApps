package com.example.core.db

import android.util.Log
import com.example.core.db.room.RoomDataSource
import com.example.core.db.room.entity.MenuEntity
import com.example.core.db.room.entity.MenuTypeEntity
import com.example.core.db.room.entity.OrderEntity
import com.example.core.db.room.entity.TransactionEntity
import com.example.core.db.room.entity.relation.OrderAndMenuEntity
import com.example.core.dispatcher.DispatcherProvider
import com.example.core.dispatcher.StandardDispatcher
import com.example.core.model.*
import com.example.core.utils.DataMapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val roomDataSource: RoomDataSource,
    private val dispatcher: DispatcherProvider
): IRepository {
    override fun getAllMenu(): Flow<List<MenuModel>> {
        return roomDataSource.getAllMenu().map { DataMapper.mapMenuEtM(it) } }

    override fun getListMenuByType(idType: Long): Flow<List<MenuModel>> {
        return roomDataSource.getListMenuByType(idType).map { DataMapper.mapMenuEtM(it) }
    }

    override fun getMenuType(): Flow<List<MenuTypeModel>> {
        return roomDataSource.getMenuType().map { DataMapper.mapTypeEtM(it) }
    }

    override fun getOrderMenuByTrans(idTrans: Long): Flow<List<OrderAndMenu>> {
        return roomDataSource.getOrderMenuByTrans(idTrans).map { DataMapper.mapOrderMenuEtM(it) }
    }

    override fun getOnGoingTrans(): Flow<List<TransactionModel>> {
        return roomDataSource.getOnGoingTrans().map { DataMapper.mapTransEtM(it) }
    }

    override fun getFinishedTrans(): Flow<List<TransactionModel>> {
        return roomDataSource.getFinishedTrans().map { DataMapper.mapTransEtM(it) }
    }

    override suspend fun insertMenu(menu: MenuModel, result: (Boolean) -> Unit) {
        CoroutineScope(dispatcher.io).launch {
            try {
                val mdata = DataMapper.menuMtE(menu)
                roomDataSource.insertMenu(mdata).apply {
                    withContext(dispatcher.main){result(true)}
                }
            }catch (e: Exception) {
                Timber.tag("Repository").e(e.message.toString())
                withContext(dispatcher.main) { result(false) }
            }
        }
    }

    override suspend fun updateMenu(menu: MenuModel, result: (Boolean) -> Unit) {
        CoroutineScope(dispatcher.io).launch {
            try {
                val newData = DataMapper.menuMtE(menu)
                roomDataSource.updateMenu(newData).apply {
                    withContext(dispatcher.main){result(true)}
                }
            }catch (e: Exception){
                Log.e("Repository", e.message.toString())
                withContext(dispatcher.main){result(false)}
            }
        }
    }

    override suspend fun deleteMenu(menu: MenuModel, result: (Boolean) -> Unit) {
        CoroutineScope(dispatcher.io).launch {
            try {
                val mData = DataMapper.menuMtE(menu)
                roomDataSource.deleteMenu(mData).apply {
                    withContext(dispatcher.main){result(true)}
                }
            }catch (e: Exception){
                Log.e("Repository", e.message.toString())
                withContext(dispatcher.main){result(false)}
            }
        }
    }

    override suspend fun insertMenuType(menuType: MenuTypeModel, result: (Boolean) -> Unit) {
        CoroutineScope(dispatcher.io).launch {
            try {
                val type = DataMapper.typeMtE(menuType)
                roomDataSource.insertMenuType(type).apply {
                    withContext(dispatcher.main){result(true)}
                }
            }catch (e: Exception){
                Log.e("Repository", e.message.toString())
                withContext(dispatcher.main){result(false)}
            }
        }
    }

    override suspend fun updateMenuType(menuType: MenuTypeModel, result: (Boolean) -> Unit) {
        CoroutineScope(dispatcher.io).launch {
            try {
                val newType = DataMapper.typeMtE(menuType)
                roomDataSource.updateMenuType(newType).apply {
                    withContext(dispatcher.main){result(true)}
                }
            }catch (e: Exception){
                Log.e("Repository", e.message.toString())
                withContext(dispatcher.main){result(false)}
            }
        }
    }

    override suspend fun deleteMenuType(menuType: MenuTypeModel, result: (Boolean) -> Unit) {
        CoroutineScope(dispatcher.io).launch {
            try {
                val type = DataMapper.typeMtE(menuType)
                roomDataSource.deleteMenuType(type).apply {
                    withContext(dispatcher.main){result(true)}
                }
            }catch (e: Exception){
                Log.e("Repository", e.message.toString())
                withContext(dispatcher.main){result(false)}
            }
        }
    }

    override suspend fun insertOrder(orderModel: OrderModel, result: (Boolean) -> Unit) {
        CoroutineScope(dispatcher.io).launch {
            try {
                val order = DataMapper.orderMtE(orderModel)
                roomDataSource.insertOrder(order).apply {
                    withContext(dispatcher.main){result(true)}
                }
            }catch (e: Exception){
                Log.e("Repository", e.message.toString())
                withContext(dispatcher.main){result(false)}
            }
        }
    }

    override suspend fun updateOrder(orderModel: OrderModel, result: (Boolean) -> Unit) {
        CoroutineScope(dispatcher.io).launch {
            try {
                val order = DataMapper.orderMtE(orderModel)
                roomDataSource.updateOrder(order).apply {
                    withContext(dispatcher.main){result(true)}
                }
            }catch (e: Exception){
                Log.e("Repository", e.message.toString())
                withContext(dispatcher.main){result(false)}
            }
        }
    }

    override suspend fun deleteOrder(orderModel: OrderModel, result: (Boolean) -> Unit) {
        CoroutineScope(dispatcher.io).launch {
            try {
                val order = DataMapper.orderMtE(orderModel)
                roomDataSource.deleteOrder(order).apply {
                    withContext(dispatcher.main){result(true)}
                }
            }catch (e: Exception){
                Log.e("Repository", e.message.toString())
                withContext(dispatcher.main){result(false)}
            }
        }
    }

    override suspend fun insertTrans(transModel: TransactionModel, result: (Boolean) -> Unit) {
        CoroutineScope(dispatcher.io).launch {
            try {
                val trans = DataMapper.transMtE(transModel)
                roomDataSource.insertTrans(trans).apply {
                    withContext(dispatcher.main){result(true)}
                }
            }catch (e: Exception){
                Log.e("Repository", e.message.toString())
                withContext(dispatcher.main){result(false)}
            }
        }
    }

    override suspend fun updateTrans(transModel: TransactionModel, result: (Boolean) -> Unit) {
        CoroutineScope(dispatcher.io).launch {
            try {
                val trans = DataMapper.transMtE(transModel)
                roomDataSource.updateTrans(trans).apply {
                    withContext(dispatcher.main){result(true)}
                }
            }catch (e: Exception){
                Log.e("Repository", e.message.toString())
                withContext(dispatcher.main){result(false)}
            }
        }
    }

    override suspend fun deleteTrans(transModel: TransactionModel, result: (Boolean) -> Unit) {
        CoroutineScope(dispatcher.io).launch {
            try {
                val trans = DataMapper.transMtE(transModel)
                roomDataSource.deleteTrans(trans).apply {
                    withContext(dispatcher.main){result(true)}
                }
            }catch (e: Exception){
                Log.e("Repository", e.message.toString())
                withContext(dispatcher.main){result(false)}
            }
        }
    }
}