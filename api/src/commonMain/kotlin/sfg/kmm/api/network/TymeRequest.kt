package sfg.kmm.api.network

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class TymeRequest(val httpClient: HttpClient) {
    suspend inline fun <reified T> get(block: HttpRequestBuilder.() -> Unit): T =
        httpClient.request {
            block.apply {
                method = HttpMethod.Get
            }
        }
}

