package com.kurt.example.rickandmorty.core.di

import dagger.Module
import dagger.Provides
import sfg.kmm.api.data.characters.CharactersRemoteSource
import sfg.kmm.api.data.characters.CharactersRemoteSourceImpl
import sfg.kmm.api.data.characters.CharactersRepositoryImpl
import sfg.kmm.api.domain.repositories.CharactersRepository
import sfg.kmm.api.domain.usecase.GetAllCharacters
import sfg.kmm.api.remote.CharactersApi

@Module
class KmmCharactersModule {
    @Provides
    fun provideCharactersRemoteSource(charactersApi: CharactersApi): CharactersRemoteSource =
        CharactersRemoteSourceImpl(charactersApi)

    @Provides
    fun provideCharactersRepository(charactersRemoteSource: CharactersRemoteSource): CharactersRepository =
        CharactersRepositoryImpl(charactersRemoteSource)

    @Provides
    fun provideGetAllCharacters(charactersRepository: CharactersRepository): GetAllCharacters =
        GetAllCharacters(charactersRepository)
}