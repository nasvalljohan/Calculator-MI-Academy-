package com.jojjnator.kalkylator.network

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class KtorClient {

    val getKtorClient = HttpClient {
        install(ContentNegotiation) {
            json(json =  Json{
                ignoreUnknownKeys = true
                coerceInputValues = true
            })
        }
    }



}