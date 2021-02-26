package sfg.kmm.api.remote

import io.ktor.client.*
import io.ktor.client.request.*
import sfg.kmm.api.dto.Character
import sfg.kmm.api.dto.RickAndMortyResponse

class CharactersApi(private val client: HttpClient) {
    suspend fun getAllCharacters(page: Int? = null): RickAndMortyResponse<Character> =
        client.get {
            url {
                encodedPath = "/character"
                parameter("page", page)
            }
        }

    suspend fun getCharacters(characterIds: List<Int>): List<Character> =
        client.get("/character/${characterIds}")

    suspend fun getCharacter(characterId: Int): Character =
        client.get("/character/${characterId}")
}