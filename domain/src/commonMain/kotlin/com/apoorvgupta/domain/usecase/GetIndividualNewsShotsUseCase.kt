package com.apoorvgupta.domain.usecase

import com.apoorvgupta.domain.model.NewsShots
import com.apoorvgupta.core.model.DataError
import com.apoorvgupta.core.model.Result

/**
 * @author Apoorv Gupta
 */

fun interface GetIndividualNewsShotsUseCase {
    suspend fun getIndividualNewsShots(postLink: String): Result<NewsShots?, DataError.Remote>
}
