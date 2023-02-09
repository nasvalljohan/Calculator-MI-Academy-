package com.jojjnator.kalkylator.model

import kotlinx.serialization.Serializable

@Serializable
data class QuoteModel(
    val character: Character,
    val sentence: String
)

@Serializable
data class House(
    val name: String,
    val slug: String
)

@Serializable
data class Character(
    val house: House,
    val name: String,
    val slug: String
)