package com.mironov.mironovtesttask.di.app.module

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.mironov.mironovtesttask.data.network.api.PokemonApi
import com.mironov.mironovtesttask.di.app.annotation.AppScope
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create

@Module
object NetworkModule {

    private const val MEDIA_TYPE = "application/json"
    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    @AppScope
    @Provides
    fun provideJsonSerializer(): Json = Json {
        ignoreUnknownKeys = true
    }

    @AppScope
    @Provides
    fun provideRetrofit(jsonSerializer: Json): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(jsonSerializer.asConverterFactory(MEDIA_TYPE.toMediaType()))
        .build()

    @AppScope
    @Provides
    fun providePokemonApi(retrofit: Retrofit): PokemonApi = retrofit.create()
}