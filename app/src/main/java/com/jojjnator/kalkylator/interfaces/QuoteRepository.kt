package com.jojjnator.kalkylator.interfaces

import com.jojjnator.kalkylator.model.QuoteModel
import com.jojjnator.kalkylator.model.Resource

interface QuoteRepository {

    suspend fun getQuote(): Resource<QuoteModel>

}