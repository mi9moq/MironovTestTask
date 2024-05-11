package com.mironov.mironovtesttask.di.app

import com.mironov.mironovtesttask.MainActivity
import com.mironov.mironovtesttask.PokemonApp
import com.mironov.mironovtesttask.di.app.annotation.AppScope
import com.mironov.mironovtesttask.di.app.module.DispatcherModule
import com.mironov.mironovtesttask.di.app.module.NetworkModule
import com.mironov.mironovtesttask.di.app.module.RepositoryModule
import com.mironov.mironovtesttask.di.pokemon_list.PokemonsComponent
import dagger.Component

@AppScope
@Component(
    modules = [
        NetworkModule::class,
        DispatcherModule::class,
        RepositoryModule::class,
    ]
)
interface AppComponent {

    fun inject(app: PokemonApp)

    fun inject(activity: MainActivity)

    fun getPokemonsComponentFactory(): PokemonsComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }
}