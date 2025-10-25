package com.apoorvgupta.network.dto.category

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author Apoorv Gupta
 */

@Serializable
data class CategoryDto(
    @SerialName("_id")
    val id: String,

    @SerialName("createdAt")
    val createdAt: String,

    @SerialName("name")
    val name: String,

    @SerialName("updatedAt")
    val updatedAt: String,
)
