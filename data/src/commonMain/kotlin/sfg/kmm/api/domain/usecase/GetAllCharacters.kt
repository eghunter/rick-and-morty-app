package sfg.kmm.api.domain.usecase

import sfg.kmm.api.domain.repositories.CharactersRepository

class GetAllCharacters(
    private val charactersRepository: CharactersRepository
) {
    suspend operator fun invoke(page: Int? = null) = charactersRepository.getAllCharacters(page)
}