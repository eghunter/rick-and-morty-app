package sfg.kmm.api.network

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.http.*
import sfg.kmm.api.network.feature.Auth
import sfg.kmm.api.network.feature.TokenExpire

val defaultClient: (host: String, tokenProvider: TokenProvider) -> HttpClient =
    { host, tokenProvider ->
        HttpClient(Platform().getClientEngine()) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }

            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }

            install(DefaultRequest) {
                url {
                    protocol = URLProtocol.HTTPS
                    this.host = host
                }
            }

            install(TokenExpire) {
                additionalInfo = "Token expire here"
            }

            install(Auth) {
                authenticationInfo = tokenProvider.getToken()
            }
        }
    }