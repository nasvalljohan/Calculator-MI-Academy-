package com.jojjnator.kalkylator.model

import kotlinx.serialization.Serializable

@Serializable
data class Character(
    val house: House,
    val name: String,
    val slug: String
)