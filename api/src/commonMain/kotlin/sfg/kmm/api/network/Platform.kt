package sfg.kmm.api.network

import io.ktor.client.engine.*

expect class Platform() {
    val clientEngine: HttpClientEngineFactory<HttpClientEngineConfig>
}