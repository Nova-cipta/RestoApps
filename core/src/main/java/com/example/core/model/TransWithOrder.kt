package com.example.core.model

data class TransWithOrder(
    var transactionModel: TransactionModel,
    var listOder: List<OrderModel>
)
