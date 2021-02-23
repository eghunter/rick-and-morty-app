package sfg.kmm.api.network

import io.ktor.client.*
import io.ktor.client.engine.ios.*

actual class ClientEngine {
    actual fun getClient(): HttpClient {
        return HttpClient(Ios)
    }
}