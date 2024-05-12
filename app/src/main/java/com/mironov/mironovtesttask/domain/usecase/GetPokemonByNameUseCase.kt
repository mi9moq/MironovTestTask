package com.mironov.mironovtesttask.domain.usecase

import com.mironov.mironovtesttask.domain.entity.PokemonDetail
import com.mironov.mironovtesttask.domain.entity.Result
import com.mironov.mironovtesttask.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonByNameUseCase @Inject constructor(
    private val repository: PokemonRepository
) {

    suspend operator fun invoke(name: String): Result<PokemonDetail> = repository.getByName(name)
}