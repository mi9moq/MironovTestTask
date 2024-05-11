package com.mironov.mironovtesttask.data.repository

import com.mironov.mironovtesttask.data.mapper.toEntity
import com.mironov.mironovtesttask.data.network.api.PokemonApi
import com.mironov.mironovtesttask.data.utils.runCatchingNonCancellation
import com.mironov.mironovtesttask.domain.entity.PokemonItem
import com.mironov.mironovtesttask.domain.entity.Result
import com.mironov.mironovtesttask.domain.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val api: PokemonApi,
) : PokemonRepository {

    override suspend fun getList(): Result<List<PokemonItem>> = withContext(Dispatchers.IO) {
        runCatchingNonCancellation {
            val pokemonList = api.getList().pokemonList.map { it.toEntity() }

            Result.Success(pokemonList)
        }
    }
}