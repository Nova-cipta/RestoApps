package com.example.core.di

import com.example.core.dispatcher.DispatcherProvider
import com.example.core.dispatcher.StandardDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DispatcherModule {

    @Singleton
    @Provides
    fun provideDispatcherProvider(): DispatcherProvider{
        return StandardDispatcher()
    }
}