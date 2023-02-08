package com.jojjnator.kalkylator.model

import kotlinx.serialization.Serializable

@Serializable
data class QuoteModel(

    val character: Character,
    val sentence: String
)