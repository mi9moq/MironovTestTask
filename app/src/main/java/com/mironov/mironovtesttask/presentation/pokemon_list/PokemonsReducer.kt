package com.mironov.mironovtesttask.presentation.pokemon_list

import vivid.money.elmslie.core.store.dsl.ScreenDslReducer
import javax.inject.Inject

class PokemonsReducer @Inject constructor(

) : ScreenDslReducer<PokemonsEvent,
        PokemonsEvent.Ui,
        PokemonsEvent.Domain,
        PokemonsState,
        PokemonsEffect,
        PokemonsCommand>(
    PokemonsEvent.Ui::class,
    PokemonsEvent.Domain::class,
) {

    override fun Result.internal(event: PokemonsEvent.Domain): Any = when (event) {
        PokemonsEvent.Domain.LoadingFailure -> {
            state {
                copy(isLoading = false, content = null)
            }
            effects {
                +PokemonsEffect.Error
            }
        }

        is PokemonsEvent.Domain.LoadingSuccess -> {
            state {
                copy(isLoading = false, content = event.pokemonList)
            }
        }
    }

    override fun Result.ui(event: PokemonsEvent.Ui): Any = when (event) {
        PokemonsEvent.Ui.Init -> {
            state {
                copy(isLoading = true, content = null)
            }
            commands {
                +PokemonsCommand.Load
            }
        }

        PokemonsEvent.Ui.Refresh -> {
            state {
                copy(isLoading = true, content = null)
            }
            commands {
                +PokemonsCommand.Load
            }
        }
    }
}