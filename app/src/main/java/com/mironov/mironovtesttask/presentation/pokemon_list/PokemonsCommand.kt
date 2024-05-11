package com.mironov.mironovtesttask.presentation.pokemon_list

sealed interface PokemonsCommand {

    data object Load: PokemonsCommand
}