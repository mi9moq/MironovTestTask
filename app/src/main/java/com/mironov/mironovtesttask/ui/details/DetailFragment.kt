package com.mironov.mironovtesttask.ui.details

import com.mironov.mironovtesttask.presentation.detail.DetailEffect
import com.mironov.mironovtesttask.presentation.detail.DetailEvent
import com.mironov.mironovtesttask.presentation.detail.DetailState
import com.mironov.mironovtesttask.ui.utils.ElmBaseFragment
import vivid.money.elmslie.core.store.Store

class DetailFragment: ElmBaseFragment<DetailEffect, DetailState, DetailEvent>() {

    override fun render(state: DetailState) {
        TODO("Not yet implemented")
    }

    override val store: Store<DetailEvent, DetailEffect, DetailState>
        get() = TODO("Not yet implemented")
}