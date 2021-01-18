package sfg.kmm.api.domain.repositories

import sfg.kmm.api.dto.Character

interface CharactersRepository {
    suspend fun getAllCharacters(page: Int? = null): List<Character>
    suspend fun getCharacters(characterIds: List<Int>): List<Character>
    suspend fun getCharacter(characterId: Int): Character
}