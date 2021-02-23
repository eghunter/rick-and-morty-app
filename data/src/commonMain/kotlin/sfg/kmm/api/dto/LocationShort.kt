package sfg.kmm.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class LocationShort(
    val name: String,
    val url: String
)