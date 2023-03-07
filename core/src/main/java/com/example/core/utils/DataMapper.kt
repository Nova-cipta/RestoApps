package com.example.core.utils

import com.example.core.db.room.entity.MenuEntity
import com.example.core.db.room.entity.MenuTypeEntity
import com.example.core.db.room.entity.OrderEntity
import com.example.core.db.room.entity.TransactionEntity
import com.example.core.db.room.entity.relation.OrderAndMenuEntity
import com.example.core.model.*

object DataMapper {
    fun menuEtM(input: MenuEntity) = MenuModel(
        idMenu = input.idMenu,
        idType = input.idType,
        menuImg = input.menuImg,
        menuName = input.menuName,
        price = input.price,
        available = input.available
    )
    fun menuMtE(input: MenuModel) = MenuEntity(
        idMenu = input.idMenu,
        idType = input.idType,
        menuImg = input.menuImg,
        menuName = input.menuName,
        price = input.price,
        available = input.available
    )
    fun mapMenuEtM(input: List<MenuEntity>): List<MenuModel>{
        val listMenu = ArrayList<MenuModel>()
        input.map {
            listMenu.add(menuEtM(it))
        }
        return listMenu
    }
    fun typeEtM(input: MenuTypeEntity) = MenuTypeModel(
        idType = input.idType,
        type = input.type
    )
    fun typeMtE(input: MenuTypeModel) = MenuTypeEntity(
        idType = input.idType,
        type = input.type
    )
    fun mapTypeEtM(input: List<MenuTypeEntity>): List<MenuTypeModel>{
        val listType = ArrayList<MenuTypeModel>()
        input.map { listType.add(typeEtM(it)) }
        return listType
    }
    fun orderEtM(input: OrderEntity) = OrderModel(
        idOrder = input.idOrder,
        idTrans = input.idTrans,
        idMenu =  input.idMenu,
        qty = input.qty,
        total = input.total
    )
    fun orderMtE(input: OrderModel) = OrderEntity(
        idOrder = input.idOrder,
        idTrans = input.idTrans,
        idMenu =  input.idMenu,
        qty = input.qty,
        total = input.total
    )
    fun mapOrderEtM(input: List<OrderEntity>): List<OrderModel>{
        val listOrder = ArrayList<OrderModel>()
        input.map { listOrder.add(orderEtM(it)) }
        return listOrder
    }
    fun transEtM(input: TransactionEntity) = TransactionModel(
        idTrans = input.idTrans,
        table = input.table,
        date = input.date,
        total = input.total,
        tax = input.tax,
        tip = input.tip,
        isDone = input.isDone
    )
    fun transMtE(input: TransactionModel) = TransactionEntity(
        idTrans = input.idTrans,
        table = input.table,
        date = input.date,
        total = input.total,
        tax = input.tax,
        tip = input.tip,
        isDone = input.isDone
    )
    fun mapTransEtM(input: List<TransactionEntity>): List<TransactionModel>{
        val listTrans = ArrayList<TransactionModel>()
        input.map { listTrans.add(transEtM(it)) }
        return listTrans
    }

    fun mapOrderMenuEtM(input: List<OrderAndMenuEntity>): List<OrderAndMenu>{
        val listOrderMenu = ArrayList<OrderAndMenu>()
        input.map { entity ->
            listOrderMenu.add(
                OrderAndMenu(
                    menuModel = menuEtM(entity.menuEntity),
                    orderModel = orderEtM(entity.orderEntity)
                )
            )
        }
        return listOrderMenu
    }
}