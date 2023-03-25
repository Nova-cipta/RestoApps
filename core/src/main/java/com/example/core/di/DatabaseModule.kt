package com.example.core.di

import android.content.Context
import androidx.room.Room
import com.example.core.db.room.RoomDao
import com.example.core.db.room.RoomDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideRoomDb(@ApplicationContext context: Context): RoomDb = Room.databaseBuilder(
        context,
        RoomDb::class.java, "Resto.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideDao(database: RoomDb): RoomDao = database.roomDao()
}