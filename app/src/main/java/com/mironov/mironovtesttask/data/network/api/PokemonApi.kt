package com.mironov.mironovtesttask.data.network.api

import com.mironov.mironovtesttask.data.network.model.PokemonDetailDto
import com.mironov.mironovtesttask.data.network.model.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon")
    suspend fun getList(
        @Query("limit") limit: Int = DEFAULT_LIMIT,
        @Query("offset") offset: Int = DEFAULT_OFFSET,
    ): PokemonListResponse

    @GET("pokemon/{name}")
    suspend fun getByName(
        @Path("name") name: String,
    ): PokemonDetailDto

    companion object {

        private const val DEFAULT_LIMIT = 50
        private const val DEFAULT_OFFSET = 0
    }
}