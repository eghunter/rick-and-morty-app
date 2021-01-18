package com.kurt.example.rickandmorty.core.di

import dagger.Module
import dagger.Provides
import sfg.kmm.api.network.KmmHttpClient
import sfg.kmm.api.network.Request
import sfg.kmm.api.remote.CharactersApi

@Module
class NetworkModule() {
    @Provides
    fun providesCharactersApi(): CharactersApi =
        CharactersApi(
            Request(
                KmmHttpClient.defaultClient("rickandmortyapi.com/api")
            )
        )
}