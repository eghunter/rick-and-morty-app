package sfg.kmm.api.network.feature

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.statement.*
import io.ktor.util.*

open class TokenExpire(val config: Config) {

    companion object Feature : HttpClientFeature<Config, TokenExpire> {
        override val key: AttributeKey<TokenExpire> = AttributeKey("TokenExpire")

        override fun install(feature: TokenExpire, scope: HttpClient) {
            scope.responsePipeline
                .intercept(HttpResponsePipeline.Parse) {

                }
        }

        override fun prepare(block: Config.() -> Unit): TokenExpire =
            TokenExpire(
                Config()
                    .apply { block() }
            )
    }

    class Config(var additionalInfo: String = "default value")
}