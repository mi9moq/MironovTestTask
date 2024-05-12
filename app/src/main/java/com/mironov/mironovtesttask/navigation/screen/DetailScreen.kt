package com.mironov.mironovtesttask.navigation.screen

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.mironov.mironovtesttask.ui.details.DetailFragment

fun getDetailsScreen(pokemonName: String) = FragmentScreen {
    DetailFragment.newInstance(pokemonName)
}