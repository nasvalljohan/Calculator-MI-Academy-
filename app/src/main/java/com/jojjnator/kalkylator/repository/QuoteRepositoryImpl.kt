package com.jojjnator.kalkylator.repository

import com.jojjnator.kalkylator.interfaces.QuoteRepository
import com.jojjnator.kalkylator.model.QuoteModel
import com.jojjnator.kalkylator.network.KtorClient
import io.ktor.client.call.*
import io.ktor.client.request.*


class QuoteRepositoryImpl(private val client: KtorClient): QuoteRepository {


    override suspend fun getQuote(): QuoteModel {
        val response = client.getKtorClient.get("https://api.gameofthronesquotes.xyz/v1/random").body<QuoteModel>()
        // Faulty API, on some data-points returns null on character.house.name/slug
        return response

    }

}