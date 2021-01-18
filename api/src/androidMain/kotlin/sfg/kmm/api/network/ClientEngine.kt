package sfg.kmm.api.network

import io.ktor.client.*
import io.ktor.client.engine.android.*

actual class ClientEngine {
    actual fun getClient(): HttpClient {
        return HttpClient(Android) {
            engine {
                connectTimeout = 100_000
                socketTimeout = 100_000
            }
        }
    }
}