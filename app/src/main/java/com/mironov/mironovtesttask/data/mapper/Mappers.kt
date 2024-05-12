package com.mironov.mironovtesttask.data.mapper

import com.mironov.mironovtesttask.data.network.model.PokemonDetailDto
import com.mironov.mironovtesttask.data.network.model.PokemonItemDto
import com.mironov.mironovtesttask.domain.entity.PokemonDetail
import com.mironov.mironovtesttask.domain.entity.PokemonItem

private const val DEFAULT_IMAGE_URL =
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"
private val regex = Regex("mon/(\\d+)/")

fun PokemonItemDto.toEntity(): PokemonItem {
    val id = regex.find(url)?.groupValues?.get(1) ?: "1"
    val iconUrl = "$DEFAULT_IMAGE_URL$id.png"
    return PokemonItem(
        name = name,
        iconUrl = iconUrl
    )
}

fun PokemonDetailDto.toEntity(): PokemonDetail = PokemonDetail(
    name = name,
    iconUrl = "$DEFAULT_IMAGE_URL$id.png",
    height = height,
    weight = weight
)