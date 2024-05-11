package com.mironov.mironovtesttask.domain.usecase

import com.mironov.mironovtesttask.domain.entity.PokemonItem
import com.mironov.mironovtesttask.domain.entity.Result
import com.mironov.mironovtesttask.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val repository: PokemonRepository
) {

    suspend operator fun invoke(): Result<List<PokemonItem>> = repository.getList()
}