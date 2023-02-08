package com.jojjnator.kalkylator.model

import kotlinx.serialization.Serializable

@Serializable
data class House(
    val name: String,
    val slug: String
)