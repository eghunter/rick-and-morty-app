package sfg.kmm.api.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Character(
    val created: String,
    @SerialName("episode")
    val episodes: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationShort,
    val origin: LocationShort,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)