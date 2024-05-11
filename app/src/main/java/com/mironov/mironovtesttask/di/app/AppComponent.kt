package com.mironov.mironovtesttask.di.app

import com.mironov.mironovtesttask.MainActivity
import com.mironov.mironovtesttask.di.app.annotation.AppScope
import com.mironov.mironovtesttask.di.app.module.DispatcherModule
import com.mironov.mironovtesttask.di.app.module.NetworkModule
import dagger.Component

@AppScope
@Component(
    modules = [
        NetworkModule::class,
        DispatcherModule::class,
    ]
)
interface AppComponent {

    fun inject(activity: MainActivity)
}