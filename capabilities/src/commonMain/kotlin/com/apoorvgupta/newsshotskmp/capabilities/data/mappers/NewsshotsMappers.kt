package com.apoorvgupta.newsshotskmp.capabilities.data.mappers

import com.apoorvgupta.newsshotskmp.capabilities.data.dto.category.CategoryDto
import com.apoorvgupta.newsshotskmp.capabilities.data.dto.newsshots.AuthorDto
import com.apoorvgupta.newsshotskmp.capabilities.data.dto.newsshots.NewsShotsDto
import com.apoorvgupta.newsshotskmp.capabilities.domain.Author
import com.apoorvgupta.newsshotskmp.capabilities.domain.Category
import com.apoorvgupta.newsshotskmp.capabilities.domain.NewsShots

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
