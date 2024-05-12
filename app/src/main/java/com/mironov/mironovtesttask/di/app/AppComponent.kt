package com.mironov.mironovtesttask.di.app

import com.mironov.mironovtesttask.ui.MainActivity
import com.mironov.mironovtesttask.PokemonApp
import com.mironov.mironovtesttask.di.app.annotation.AppScope
import com.mironov.mironovtesttask.di.app.module.DispatcherModule
import com.mironov.mironovtesttask.di.app.module.NavigationModule
import com.mironov.mironovtesttask.di.app.module.NetworkModule
import com.mironov.mironovtesttask.di.app.module.RepositoryModule
import com.mironov.mironovtesttask.di.detail.DetailComponent
import com.mironov.mironovtesttask.di.pokemon_list.PokemonsComponent
import dagger.Component

@AppScope
@Component(
    modules = [
        NetworkModule::class,
        DispatcherModule::class,
        RepositoryModule::class,
        NavigationModule::class,
    ]
)
interface AppComponent {

    fun inject(app: PokemonApp)

    fun inject(activity: MainActivity)

    fun getPokemonsComponentFactory(): PokemonsComponent.Factory

    fun getDetailComponentFactory(): DetailComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }
}