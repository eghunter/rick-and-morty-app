package sfg.kmm.api.data.characters

import sfg.kmm.api.dto.Character
import sfg.kmm.api.remote.CharactersApi

class CharactersRemoteSourceImpl(val api: CharactersApi) : CharactersRemoteSource {
    override suspend fun getAllCharacters(page: Int?): List<Character> {
        print("sfhunter get all character")
        return api.getAllCharacters(page).results
    }

    override suspend fun getCharacters(characterIds: List<Int>) =
        api.getCharacters(characterIds)

    override suspend fun getCharacter(characterId: Int) =
        api.getCharacter(characterId)
}