package com.example.core.di

import com.example.core.db.room.RoomDao
import com.example.core.db.room.RoomDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideDao(database: RoomDb): RoomDao = database.roomDao()
}