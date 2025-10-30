package com.apoorvgupta.domain.usecase

import com.apoorvgupta.core.model.DataError
import com.apoorvgupta.core.model.Result
import com.apoorvgupta.domain.model.NewsShots

/**
 * @author Apoorv Gupta
 */

fun interface GetIndividualNewsShotsUseCase {
    suspend operator fun invoke(postLink: String): Result<NewsShots?, DataError.Remote>
}
