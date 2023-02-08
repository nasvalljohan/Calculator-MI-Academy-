package com.jojjnator.kalkylator.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class House(
    @SerialName("name")
    val name: String,
    @SerialName("slug")
    val slug: String
)