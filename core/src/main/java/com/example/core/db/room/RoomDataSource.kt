package com.example.core.db.room

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomDataSource @Inject constructor(private val  roomDao: RoomDao) {

}