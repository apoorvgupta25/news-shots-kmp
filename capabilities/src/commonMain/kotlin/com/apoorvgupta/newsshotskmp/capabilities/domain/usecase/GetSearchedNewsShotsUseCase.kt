package com.apoorvgupta.newsshotskmp.capabilities.domain.usecase

import com.apoorvgupta.newsshotskmp.capabilities.domain.NewsShots
import com.apoorvgupta.newsshotskmp.core.domain.DataError
import com.apoorvgupta.newsshotskmp.core.domain.Result

/**
 * Get searched news shots use case
 *
 * @constructor Create empty Get searched news shots use case
 *
 * @author Apoorv Gupta
 */
fun interface GetSearchedNewsShotsUseCase {
    suspend fun getSearchedNewsShots(searchKeyword: String): Result<List<NewsShots>?, DataError.Remote>
}
