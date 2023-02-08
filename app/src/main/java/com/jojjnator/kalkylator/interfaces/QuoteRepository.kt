package com.jojjnator.kalkylator.interfaces

import com.jojjnator.kalkylator.model.QuoteModel


interface QuoteRepository {
    suspend fun getQuote(): QuoteModel

}