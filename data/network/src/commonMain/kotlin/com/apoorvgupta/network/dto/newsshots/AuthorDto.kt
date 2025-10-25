package com.apoorvgupta.network.dto.newsshots

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author Apoorv Gupta
 */

@Serializable
data class AuthorDto(
    @SerialName("name")
    val name: String,
)
