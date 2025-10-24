package com.apoorvgupta.domain.usecase

import com.apoorvgupta.domain.model.NewsShots
import com.apoorvgupta.newsshotskmp.core.model.DataError
import com.apoorvgupta.newsshotskmp.core.model.Result

/**
 * Get recent news shots use case
 *
 * @constructor Create empty Get recent news shots use case
 *
 * @author Apoorv Gupta
 */
fun interface GetRecentNewsShotsUseCase {
    suspend fun getRecentNewsShots(): Result<List<NewsShots>?, DataError.Remote>
}
