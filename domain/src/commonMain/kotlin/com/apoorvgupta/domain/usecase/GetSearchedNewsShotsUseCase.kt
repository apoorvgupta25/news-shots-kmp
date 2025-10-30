package com.apoorvgupta.domain.usecase

import com.apoorvgupta.core.model.DataError
import com.apoorvgupta.core.model.Result
import com.apoorvgupta.domain.model.NewsShots

/**
 * Get searched news shots use case
 *
 * @constructor Create empty Get searched news shots use case
 *
 * @author Apoorv Gupta
 */
fun interface GetSearchedNewsShotsUseCase {
    suspend operator fun invoke(searchKeyword: String): Result<List<NewsShots>?, DataError.Remote>
}
