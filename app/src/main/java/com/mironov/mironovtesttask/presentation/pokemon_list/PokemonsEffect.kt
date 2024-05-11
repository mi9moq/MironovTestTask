package com.mironov.mironovtesttask.presentation.pokemon_list

sealed interface PokemonsEffect {

    data object Error : PokemonsEffect
}