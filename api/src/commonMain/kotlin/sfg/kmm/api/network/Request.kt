package sfg.kmm.api.network

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class Request(val httpClient: HttpClient) {

    suspend inline fun <reified T> get(
        path: String = "/"
    ): T = httpClient
        .get {
            url {
                protocol = URLProtocol.HTTPS
                encodedPath = path
            }
        }
}

