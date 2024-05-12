package com.mironov.mironovtesttask.navigation.router

import com.github.terrakok.cicerone.Router
import javax.inject.Inject

interface DetailsRouter {

    fun back()
}

class DetailsRouterImpl @Inject constructor(
    private val router: Router
) : DetailsRouter {

    override fun back() {
        router.exit()
    }
}