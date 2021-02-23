package sfg.kmm.api.data.characters

import sfg.kmm.api.dto.Character

interface CharactersRemoteSource {
    suspend fun getAllCharacters(page: Int? = null): List<Character>
    suspend fun getCharacters(characterIds: List<Int>): List<Character>
    suspend fun getCharacter(characterId: Int): Character
}