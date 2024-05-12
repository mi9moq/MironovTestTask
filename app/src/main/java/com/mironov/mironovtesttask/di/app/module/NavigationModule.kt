package com.mironov.mironovtesttask.di.app.module

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Cicerone.Companion.create
import com.github.terrakok.cicerone.NavigatorHolder
import com.mironov.mironovtesttask.di.app.annotation.AppScope
import dagger.Module
import dagger.Provides

@Module
object NavigationModule {

    private val cicerone: Cicerone<Router> = create()

    @AppScope
    @Provides
    fun provideRouter(): Router = cicerone.router

    @AppScope
    @Provides
    fun provideNavigationHolder(): NavigatorHolder = cicerone.getNavigatorHolder()
}