package com.apoorvgupta.newsshotskmp.capabilities.domain.usecase

import com.apoorvgupta.newsshotskmp.capabilities.domain.NewsShots
import com.apoorvgupta.newsshotskmp.core.domain.DataError
import com.apoorvgupta.newsshotskmp.core.domain.Result

/**
 * @author Apoorv Gupta
 */

fun interface GetIndividualNewsShotsUseCase {
    suspend fun getIndividualNewsShots(postLink: String): Result<NewsShots?, DataError.Remote>
}
