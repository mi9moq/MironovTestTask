package com.mironov.mironovtesttask.presentation.detail

import com.mironov.mironovtesttask.domain.entity.Result
import com.mironov.mironovtesttask.domain.usecase.GetPokemonByNameUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import vivid.money.elmslie.core.store.Actor
import javax.inject.Inject

class DetailActor @Inject constructor(
    private val useCase: GetPokemonByNameUseCase
) : Actor<DetailCommand, DetailEvent>() {

    override fun execute(command: DetailCommand): Flow<DetailEvent> = flow {
        val event = when (command) {
            is DetailCommand.Load -> loadPokemon(command.name)
        }
        emit(event)
    }

    private suspend fun loadPokemon(name: String): DetailEvent.Domain =
        when (val result = useCase(name)) {
            is Result.Failure -> DetailEvent.Domain.LoadingFailure
            is Result.Success -> DetailEvent.Domain.LoadingSuccess(result.content)
        }
}