package com.mironov.mironovtesttask.data.network.api

import com.mironov.mironovtesttask.data.network.model.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon")
    suspend fun getList(
        @Query("limit") limit: Int = 30,
        @Query("offset") offset: Int = 0,
    ): PokemonListResponse
}