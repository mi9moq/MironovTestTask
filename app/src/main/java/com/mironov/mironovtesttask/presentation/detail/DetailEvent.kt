package com.mironov.mironovtesttask.presentation.detail

import com.mironov.mironovtesttask.domain.entity.PokemonDetail

sealed interface DetailEvent {

    sealed class Ui : DetailEvent {

        data class Init(val name: String) : Ui()

        data class Refresh(val name: String) : Ui()
    }

    sealed class Domain : DetailEvent {

        data class LoadingSuccess(val pokemon: PokemonDetail) : Domain()

        data object LoadingFailure : Domain()
    }
}