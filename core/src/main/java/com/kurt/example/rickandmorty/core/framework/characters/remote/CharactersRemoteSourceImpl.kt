package com.kurt.example.rickandmorty.core.framework.characters.remote

import com.kurt.example.rickandmorty.core.data.characters.CharactersRemoteSource
import com.kurt.example.rickandmorty.core.domain.entities.Character
import com.kurt.example.rickandmorty.core.domain.entities.LocationShort
import retrofit2.HttpException
import sfg.kmm.api.remote.CharactersApi
import javax.inject.Inject

/**
 * Copyright 2019, Kurt Renzo Acosta, All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 08/05/2019
 */
class CharactersRemoteSourceImpl
@Inject constructor(val api: CharactersApi) : CharactersRemoteSource {
    override suspend fun getAllCharacters(page: Int?): List<Character> =
        try {
            api.getAllCharacters(page).results
                .map { mapCharacter(it) }
        } catch (exception: HttpException) {
            if (exception.code() == 404) listOf() else throw exception
        }

    override suspend fun getCharacters(characterIds: List<Int>) =
        api.getCharacters(characterIds)
            .map { mapCharacter(it) }

    override suspend fun getCharacter(characterId: Int) =
        api.getCharacter(characterId)
            .let { mapCharacter(it) }

    fun mapCharacter(value: sfg.kmm.api.dto.Character): Character {
        return Character(
            value.created,
            value.episodes,
            value.gender,
            value.id,
            value.image,
            LocationShort(value.location.name, value.location.url),
            LocationShort(value.origin.name, value.origin.url),
            value.name,
            value.species,
            value.status,
            value.type,
            value.url
        )
    }
}