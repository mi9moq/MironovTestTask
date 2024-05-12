package com.mironov.mironovtesttask.di.detail

import com.mironov.mironovtesttask.navigation.router.DetailsRouter
import com.mironov.mironovtesttask.navigation.router.DetailsRouterImpl
import com.mironov.mironovtesttask.presentation.detail.DetailActor
import com.mironov.mironovtesttask.presentation.detail.DetailCommand
import com.mironov.mironovtesttask.presentation.detail.DetailEffect
import com.mironov.mironovtesttask.presentation.detail.DetailEvent
import com.mironov.mironovtesttask.presentation.detail.DetailReducer
import com.mironov.mironovtesttask.presentation.detail.DetailState
import dagger.Module
import dagger.Provides
import vivid.money.elmslie.core.store.ElmStore

@Module
class DetailModule {

    @DetailsScope
    @Provides
    fun provideDetailState(): DetailState = DetailState()

    @DetailsScope
    @Provides
    fun provideDetailStore(
        state: DetailState,
        actor: DetailActor,
        reducer: DetailReducer
    ): ElmStore<DetailEvent, DetailState, DetailEffect, DetailCommand> = ElmStore(
        initialState = state,
        reducer = reducer,
        actor = actor
    )

    @DetailsScope
    @Provides
    fun provideDetailRouter(impl: DetailsRouterImpl): DetailsRouter = impl
}