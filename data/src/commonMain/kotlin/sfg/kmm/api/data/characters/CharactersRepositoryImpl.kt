package sfg.kmm.api.data.characters

import sfg.kmm.api.domain.repositories.CharactersRepository

class CharactersRepositoryImpl(
    private val remoteSource: CharactersRemoteSource
) : CharactersRepository {
    override suspend fun getCharacters(characterIds: List<Int>) =
        remoteSource.getCharacters(characterIds)

    override suspend fun getAllCharacters(page: Int?) =
        remoteSource.getAllCharacters(page)

    override suspend fun getCharacter(characterId: Int) =
        remoteSource.getCharacter(characterId)
}