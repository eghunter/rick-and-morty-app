package sfg.kmm.api.network

import io.ktor.client.engine.*
import io.ktor.client.engine.ios.*

actual class Platform actual constructor() {

    actual fun getClientEngine(): HttpClientEngineFactory<HttpClientEngineConfig> =
        Ios
}