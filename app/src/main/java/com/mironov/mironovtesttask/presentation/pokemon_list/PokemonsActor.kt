package com.mironov.mironovtesttask.presentation.pokemon_list

import com.mironov.mironovtesttask.domain.entity.Result
import com.mironov.mironovtesttask.domain.usecase.GetPokemonListUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import vivid.money.elmslie.core.store.Actor
import javax.inject.Inject

class PokemonsActor @Inject constructor(
    private val useCase: GetPokemonListUseCase,
) : Actor<PokemonsCommand, PokemonsEvent>() {

    override fun execute(command: PokemonsCommand): Flow<PokemonsEvent> = flow {
        val event = when (command) {
            PokemonsCommand.Load -> load()
        }
        emit(event)
    }

    private suspend fun load(): PokemonsEvent.Domain =
        when (val result = useCase()) {
            is Result.Failure -> PokemonsEvent.Domain.LoadingFailure
            is Result.Success -> PokemonsEvent.Domain.LoadingSuccess(result.content)
        }
}