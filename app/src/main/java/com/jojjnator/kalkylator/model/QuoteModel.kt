package com.jojjnator.kalkylator.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuoteModel(

    @SerialName("character")
    val character: Character,

    @SerialName("sentence")
    val sentence: String
)