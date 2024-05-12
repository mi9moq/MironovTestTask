package com.mironov.mironovtesttask.presentation.detail

sealed interface DetailEffect {

    data object Error : DetailEffect
}