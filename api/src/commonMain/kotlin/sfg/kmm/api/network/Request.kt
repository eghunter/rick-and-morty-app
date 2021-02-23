package sfg.kmm.api.network

import io.ktor.client.request.*

interface Request {
    suspend fun <T> get(block: HttpRequestBuilder.() -> Unit): T
}