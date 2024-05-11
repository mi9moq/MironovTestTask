package com.mironov.mironovtesttask.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonListResponse(
    @SerialName("results")
    val pokemonList: List<PokemonItemDto>
)