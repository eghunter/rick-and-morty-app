package sfg.kmm.api.network.feature

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.util.*

open class Auth(val authenticationInfo: String) {

    public companion object Feature : HttpClientFeature<Config, Auth> {
        override val key: AttributeKey<Auth> = AttributeKey("TokenExpire")

        override fun install(feature: Auth, scope: HttpClient) {
            scope.requestPipeline
                .intercept(HttpRequestPipeline.Before) {
                    context.header("Authentication", feature.authenticationInfo)
                }
        }

        override fun prepare(block: Config.() -> Unit): Auth =
            Auth(
                Auth.Config().apply(block).authenticationInfo
            )
    }

    class Config(var authenticationInfo: String = "you need to add authentication info")
}