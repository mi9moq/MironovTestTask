package com.mironov.mironovtesttask.presentation.pokemon_list

import com.mironov.mironovtesttask.domain.entity.PokemonItem

data class PokemonsState(
    val isLoading: Boolean = true,
    val content: List<PokemonItem>? = null
)
