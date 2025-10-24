package com.apoorvgupta.newsshotskmp.capabilities.data.dto.newsshots

import com.apoorvgupta.core.utils.emptyValue
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
