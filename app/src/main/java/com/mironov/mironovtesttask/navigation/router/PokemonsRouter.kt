package com.mironov.mironovtesttask.navigation.router

import com.github.terrakok.cicerone.Router
import com.mironov.mironovtesttask.navigation.screen.getDetailsScreen
import javax.inject.Inject

interface PokemonsRouter {

    fun openDetail(pokemonName: String)
}

class PokemonsRouterImpl @Inject constructor(
    private val router: Router
) : PokemonsRouter {

    override fun openDetail(pokemonName: String) {
        router.navigateTo(getDetailsScreen(pokemonName))
    }
}