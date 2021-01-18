package sfg.kmm.api.network

import io.ktor.client.*

expect class ClientEngine() {
    fun getClient(): HttpClient
}