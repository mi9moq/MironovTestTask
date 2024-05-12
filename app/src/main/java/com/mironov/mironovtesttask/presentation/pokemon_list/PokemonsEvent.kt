package com.mironov.mironovtesttask.presentation.pokemon_list

import com.mironov.mironovtesttask.domain.entity.PokemonItem

sealed interface PokemonsEvent {

    sealed class Ui : PokemonsEvent {

        data object Init : Ui()

        data object Refresh : Ui()

        data class OnItemClicked(val name: String): Ui()
    }

    sealed class Domain : PokemonsEvent {

        data class LoadingSuccess(val pokemonList: List<PokemonItem>) : Domain()

        data object LoadingFailure : Domain()
    }
}