package com.mironov.mironovtesttask.presentation.detail

sealed interface DetailCommand {

    data class Load(val name: String): DetailCommand
}