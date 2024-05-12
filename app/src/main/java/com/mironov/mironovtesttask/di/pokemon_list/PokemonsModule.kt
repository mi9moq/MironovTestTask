package com.mironov.mironovtesttask.di.pokemon_list

import com.mironov.mironovtesttask.navigation.router.PokemonsRouter
import com.mironov.mironovtesttask.navigation.router.PokemonsRouterImpl
import com.mironov.mironovtesttask.presentation.pokemon_list.PokemonsActor
import com.mironov.mironovtesttask.presentation.pokemon_list.PokemonsCommand
import com.mironov.mironovtesttask.presentation.pokemon_list.PokemonsEffect
import com.mironov.mironovtesttask.presentation.pokemon_list.PokemonsEvent
import com.mironov.mironovtesttask.presentation.pokemon_list.PokemonsReducer
import com.mironov.mironovtesttask.presentation.pokemon_list.PokemonsState
import dagger.Module
import dagger.Provides
import vivid.money.elmslie.core.store.ElmStore

@Module
class PokemonsModule {

    @PokemonsScope
    @Provides
    fun providePokemonsState(): PokemonsState = PokemonsState()

    @PokemonsScope
    @Provides
    fun providePokemonsStore(
        state: PokemonsState,
        actor: PokemonsActor,
        reducer: PokemonsReducer
    ): ElmStore<PokemonsEvent, PokemonsState, PokemonsEffect, PokemonsCommand> = ElmStore(
        initialState = state,
        reducer = reducer,
        actor = actor
    )

    @PokemonsScope
    @Provides
    fun providePokemonsRouter(impl: PokemonsRouterImpl): PokemonsRouter = impl
}