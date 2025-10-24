package com.apoorvgupta.domain.usecase

import com.apoorvgupta.domain.model.NewsShots
import com.apoorvgupta.newsshotskmp.core.model.DataError
import com.apoorvgupta.newsshotskmp.core.model.Result

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
