package com.mironov.mironovtesttask.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class PokemonItemDto(
    val name: String,
    val url: String
)