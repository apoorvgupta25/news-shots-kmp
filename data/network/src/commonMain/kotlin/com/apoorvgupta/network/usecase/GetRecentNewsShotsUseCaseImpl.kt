package com.apoorvgupta.network.usecase

import com.apoorvgupta.domain.repo.NewsShotsRepo
import com.apoorvgupta.domain.usecase.GetRecentNewsShotsUseCase
import com.apoorvgupta.network.helper.Constants

/**
 * Get recent news shots use case impl
 *
 * @property newsShotsRepo
 * @constructor Create empty Get recent news shots use case impl
 *
 * @author Apoorv Gupta
 */
class GetRecentNewsShotsUseCaseImpl(
    private val newsShotsRepo: NewsShotsRepo,
) : GetRecentNewsShotsUseCase {

    /**
     * Get recent news shots
     *
     * @return
     */
    override suspend fun getRecentNewsShots() = newsShotsRepo.getRecentNewsShots(
        limit = Constants.DAILY_POST_LIMIT,
        sortBy = Constants.DAILY_POST_SORT_BY_CREATED,
    )
}
