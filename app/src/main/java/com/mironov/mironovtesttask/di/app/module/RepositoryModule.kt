package com.mironov.mironovtesttask.di.app.module

import com.mironov.mironovtesttask.data.repository.PokemonRepositoryImpl
import com.mironov.mironovtesttask.di.app.annotation.AppScope
import com.mironov.mironovtesttask.domain.repository.PokemonRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @AppScope
    @Binds
    fun bindPokemonRepository(impl: PokemonRepositoryImpl): PokemonRepository
}