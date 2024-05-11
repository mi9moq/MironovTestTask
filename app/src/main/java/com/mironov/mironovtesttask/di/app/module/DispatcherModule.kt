package com.mironov.mironovtesttask.di.app.module

import com.mironov.mironovtesttask.di.app.annotation.AppScope
import com.mironov.mironovtesttask.di.app.annotation.IoDispatcher
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
object DispatcherModule {
    @AppScope
    @Provides
    @IoDispatcher
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}