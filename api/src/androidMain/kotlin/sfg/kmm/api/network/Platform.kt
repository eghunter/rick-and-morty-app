package sfg.kmm.api.network

import io.ktor.client.engine.*
import io.ktor.client.engine.android.*

actual class Platform actual constructor() {
    actual val clientEngine: HttpClientEngineFactory<HttpClientEngineConfig>
        get() = Android.apply {
            create {
            }
        }
}