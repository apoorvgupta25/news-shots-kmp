package com.apoorvgupta.newsshotskmp.capabilities.data.mappers

import com.apoorvgupta.domain.model.Author
import com.apoorvgupta.domain.model.Category
import com.apoorvgupta.domain.model.NewsShots
import com.apoorvgupta.newsshotskmp.capabilities.data.dto.category.CategoryDto
import com.apoorvgupta.newsshotskmp.capabilities.data.dto.newsshots.AuthorDto
import com.apoorvgupta.newsshotskmp.capabilities.data.dto.newsshots.NewsShotsDto

/**
 * @author Apoorv Gupta
 */

fun NewsShotsDto.toNewsShots() =
    NewsShots(
        id = id,
        author = author.toAuthor(),
        category = category.toCategory(),
        content = content,
        createdAt = createdAt,
        description = description,
        link = link,
        title = title,
        updatedAt = updatedAt,
    )


fun AuthorDto.toAuthor() =
    Author(
        name = name
    )


fun CategoryDto.toCategory() =
    Category(
        id = id,
        createdAt = createdAt,
        name = name,
        updatedAt = updatedAt,
    )
