package com.mironov.mironovtesttask

import android.app.Application
import com.mironov.mironovtesttask.di.app.DaggerAppComponent

class PokemonApp: Application() {

    val component by lazy {
        DaggerAppComponent.factory().create()
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }
}