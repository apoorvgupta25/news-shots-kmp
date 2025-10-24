package com.apoorvgupta.newsshotskmp.capabilities.data.dto.newsshots

import com.apoorvgupta.newsshotskmp.capabilities.data.dto.category.CategoryDto
import com.apoorvgupta.core.utils.emptyValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author Apoorv Gupta
 */

@Serializable
data class NewsShotsDto(
    @SerialName("_id")
    val id: String,

    @SerialName("author")
    val author: AuthorDto,

    @SerialName("category")
    val category: CategoryDto,

    @SerialName("content")
    val content: String? = null,

    @SerialName("createdAt")
    val createdAt: String,

    @SerialName("description")
    val description: String,

    @SerialName("link")
    val link: String,

    @SerialName("title")
    val title: String,

    @SerialName("updatedAt")
    val updatedAt: String? = null,
)