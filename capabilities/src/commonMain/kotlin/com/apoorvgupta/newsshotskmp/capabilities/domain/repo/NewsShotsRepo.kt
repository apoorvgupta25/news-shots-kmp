package com.apoorvgupta.newsshotskmp.capabilities.domain.repo

import androidx.paging.PagingData
import com.apoorvgupta.newsshotskmp.capabilities.domain.Category
import com.apoorvgupta.newsshotskmp.capabilities.domain.NewsShots
import com.apoorvgupta.newsshotskmp.core.domain.DataError
import com.apoorvgupta.newsshotskmp.core.domain.Result
import kotlinx.coroutines.flow.Flow

/**
 * @author Apoorv Gupta
 */
interface NewsShotsRepo {

    suspend fun getRecentNewsShots(limit: Int, sortBy: String): Result<List<NewsShots>?, DataError.Remote>

    fun getNewsShotsByCategory(categoryName: String): Flow<PagingData<NewsShots>>

    suspend fun getIndividualNewsShots(postLink: String): Result<NewsShots?, DataError.Remote>

    suspend fun getSearchedNewsShots(searchKeyword: String): Result<List<NewsShots>?, DataError.Remote>

    suspend fun getCategories(): Result<List<Category>?, DataError.Remote>

    fun getAllNewsShots(): Flow<PagingData<NewsShots>>
}