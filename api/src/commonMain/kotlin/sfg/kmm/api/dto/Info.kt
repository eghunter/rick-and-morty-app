package sfg.kmm.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class Info(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)