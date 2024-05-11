package com.mironov.mironovtesttask.ui.utils

import android.content.Context
import androidx.core.view.isVisible
import com.facebook.shimmer.ShimmerFrameLayout
import com.mironov.mironovtesttask.PokemonApp
import com.mironov.mironovtesttask.di.app.AppComponent

fun Context.appComponent(): AppComponent = (applicationContext as PokemonApp).component

fun ShimmerFrameLayout.show() {
    isVisible = true
    startShimmer()
}

fun ShimmerFrameLayout.hide() {
    stopShimmer()
    isVisible = false
}
