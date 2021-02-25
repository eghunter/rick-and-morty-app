package sfg.kmm.api.network.feature

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.statement.*
import io.ktor.util.*

open class TokenExpire(val additionalInfo: String) {

    public companion object Feature : HttpClientFeature<TokenExpireConfig, TokenExpire> {
        override val key: AttributeKey<TokenExpire>
            get() = AttributeKey("TokenExpire")

        override fun install(feature: TokenExpire, scope: HttpClient) {
            scope.responsePipeline
                .intercept(HttpResponsePipeline.Parse) {
                    print("sfhunter: TokenExpire: #${feature.additionalInfo}")
                }
        }

        override fun prepare(block: TokenExpireConfig.() -> Unit): TokenExpire =
            TokenExpire(
                TokenExpireConfig().apply(block).additionalInfo
            )
    }

    class TokenExpireConfig(var additionalInfo: String = "")
}