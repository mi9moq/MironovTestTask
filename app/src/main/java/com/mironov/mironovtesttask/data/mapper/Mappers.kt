package com.mironov.mironovtesttask.data.mapper

import com.mironov.mironovtesttask.data.network.model.PokemonItemDto
import com.mironov.mironovtesttask.domain.entity.PokemonItem

private const val DEFAULT_IMAGE_URL = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"

fun PokemonItemDto.toEntity(): PokemonItem {
    val id = url.dropLast(1).last().digitToInt()
    val iconUrl = "$DEFAULT_IMAGE_URL$id.png"
    return PokemonItem(
        name = name,
        iconUrl = iconUrl
    )
}