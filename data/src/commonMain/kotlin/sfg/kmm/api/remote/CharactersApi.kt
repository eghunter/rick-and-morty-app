package sfg.kmm.api.remote

import sfg.kmm.api.network.Request
import sfg.kmm.api.dto.Character
import sfg.kmm.api.dto.RickAndMortyResponse

class CharactersApi(val request: Request) {
    suspend fun getAllCharacters(page: Int? = null): RickAndMortyResponse<Character> =
        request.get("/character?page=${page}")

    suspend fun getCharacters(characterIds: List<Int>): List<Character> =
        request.get("/character/${characterIds}")

    suspend fun getCharacter(characterId: Int): Character =
        request.get("/character/${characterId}")
}