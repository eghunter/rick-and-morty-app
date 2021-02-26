package com.kurt.example.rickandmorty.core.di

import dagger.Module
import dagger.Provides
import sfg.kmm.api.network.TokenProvider
import sfg.kmm.api.network.defaultClient
import sfg.kmm.api.remote.CharactersApi

@Module
class NetworkModule() {
    @Provides
    fun providesCharactersApi(): CharactersApi =
        CharactersApi(
            defaultClient(
                "rickandmortyapi.com/api",
                object : TokenProvider {
                    override fun getToken(): String = "bear: sfhunter token"
                }
            )
        )
}