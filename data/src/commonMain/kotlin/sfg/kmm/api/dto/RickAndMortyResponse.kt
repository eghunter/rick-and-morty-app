package sfg.kmm.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class RickAndMortyResponse<T>(
    val info: Info,
    val results: List<T>
)