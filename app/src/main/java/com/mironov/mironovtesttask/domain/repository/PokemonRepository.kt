package com.mironov.mironovtesttask.domain.repository

import com.mironov.mironovtesttask.domain.entity.PokemonDetail
import com.mironov.mironovtesttask.domain.entity.PokemonItem
import com.mironov.mironovtesttask.domain.entity.Result

interface PokemonRepository {

    suspend fun getList(): Result<List<PokemonItem>>

    suspend fun getByName(name: String): Result<PokemonDetail>
}