package com.mironov.mironovtesttask.di.detail

import com.mironov.mironovtesttask.ui.details.DetailFragment
import dagger.Subcomponent

@DetailsScope
@Subcomponent(
    modules = [
        DetailModule::class
    ]
)
interface DetailComponent {

    fun inject(fragment: DetailFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): DetailComponent
    }
}