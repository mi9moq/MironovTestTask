package com.mironov.mironovtesttask.presentation.detail

import vivid.money.elmslie.core.store.dsl.ScreenDslReducer
import javax.inject.Inject

class DetailReducer @Inject constructor(

) : ScreenDslReducer<DetailEvent,
        DetailEvent.Ui,
        DetailEvent.Domain,
        DetailState,
        DetailEffect,
        DetailCommand>(
    DetailEvent.Ui::class,
    DetailEvent.Domain::class,
) {

    override fun Result.internal(event: DetailEvent.Domain): Any = when (event) {
        DetailEvent.Domain.LoadingFailure -> {
            state {
                copy(isLoading = false, content = null)
            }
            effects {
                +DetailEffect.Error
            }
        }

        is DetailEvent.Domain.LoadingSuccess -> {
            state {
                copy(isLoading = false, content = event.pokemon)
            }
        }
    }

    override fun Result.ui(event: DetailEvent.Ui): Any = when (event) {
        is DetailEvent.Ui.Init -> {
            state {
                copy(isLoading = true, content = null)
            }
            commands {
                +DetailCommand.Load(event.name)
            }
        }

        is DetailEvent.Ui.Refresh -> {
            state {
                copy(isLoading = true, content = null)
            }
            commands {
                +DetailCommand.Load(event.name)
            }
        }
    }
}