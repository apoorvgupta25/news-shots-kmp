package com.apoorvgupta.network.datasource

import com.apoorvgupta.core.model.DataError
import com.apoorvgupta.core.model.Result
import com.apoorvgupta.network.dto.category.CategoryDto
import com.apoorvgupta.network.dto.newsshots.NewsShotsDto

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
        search: String,
    ): Result<List<NewsShotsDto>, DataError.Remote>
}
