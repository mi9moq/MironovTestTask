package com.mironov.mironovtesttask.di.pokemon_list

import com.mironov.mironovtesttask.ui.pokemon_list.PokemonsFragment
import dagger.Subcomponent

@PokemonsScope
@Subcomponent(
    modules = [PokemonsModule::class]
)
interface PokemonsComponent {

    fun inject(fragment: PokemonsFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): PokemonsComponent
    }
}