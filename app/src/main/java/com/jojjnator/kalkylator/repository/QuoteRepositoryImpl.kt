package com.jojjnator.kalkylator.repository

import com.jojjnator.kalkylator.interfaces.QuoteRepository
import com.jojjnator.kalkylator.model.QuoteModel
import com.jojjnator.kalkylator.network.KtorClient
import io.ktor.client.call.*
import io.ktor.client.request.*


class QuoteRepositoryImpl: QuoteRepository {

    private val client = KtorClient()
    override suspend fun getQuote(): QuoteModel {
        return client.getKtorClient.get("https://api.gameofthronesquotes.xyz/v1/random").body()
    }

}