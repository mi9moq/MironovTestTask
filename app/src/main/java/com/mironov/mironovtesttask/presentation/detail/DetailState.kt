package com.mironov.mironovtesttask.presentation.detail

import com.mironov.mironovtesttask.domain.entity.PokemonDetail

data class DetailState(
    val isLoading: Boolean = false,
    val content: PokemonDetail? = null
)