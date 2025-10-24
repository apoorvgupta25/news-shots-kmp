package com.apoorvgupta.newsshotskmp.capabilities.data.network

import com.apoorvgupta.newsshotskmp.capabilities.data.dto.category.CategoryDto
import com.apoorvgupta.newsshotskmp.capabilities.data.dto.newsshots.NewsShotsDto
import com.apoorvgupta.newsshotskmp.core.model.DataError
import com.apoorvgupta.newsshotskmp.core.model.Result

/**
 * @author Apoorv Gupta
 */
interface RemoteNewsShotsDataSource {

    suspend fun getDailyNewsShots(
        limit: Int,
        sortBy: String,
        skip: Int = 0,
    ): Result<List<NewsShotsDto>, DataError.Remote>

    suspend fun getAllCategories(): Result<List<CategoryDto>, DataError.Remote>

    suspend fun getPostByCategory(
        categoryName: String,
        limit: Int,
        skip: Int,
    ): Result<List<NewsShotsDto>, DataError.Remote>

    suspend fun getIndividualPost(
        postLink: String,
    ): Result<NewsShotsDto, DataError.Remote>

    suspend fun getSearchedPost(
        search: String
    ): Result<List<NewsShotsDto>, DataError.Remote>
}