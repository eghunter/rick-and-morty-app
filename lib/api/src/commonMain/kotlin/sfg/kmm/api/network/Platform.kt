package sfg.kmm.api.network

import io.ktor.client.engine.*

expect class Platform() {
    fun getClientEngine(): HttpClientEngineFactory<HttpClientEngineConfig>
}