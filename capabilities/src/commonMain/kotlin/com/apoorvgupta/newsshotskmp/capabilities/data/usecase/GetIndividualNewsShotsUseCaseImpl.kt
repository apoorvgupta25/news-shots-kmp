package com.apoorvgupta.newsshotskmp.capabilities.data.usecase

import com.apoorvgupta.newsshotskmp.capabilities.domain.repo.NewsShotsRepo
import com.apoorvgupta.newsshotskmp.capabilities.domain.usecase.GetIndividualNewsShotsUseCase

/**
 * @author Apoorv Gupta
 */
class GetIndividualNewsShotsUseCaseImpl(
    private val newsShotsRepo: NewsShotsRepo,
) : GetIndividualNewsShotsUseCase {

    /**
     * Get individual news shots
     *
     * @param postLink
     * @return
     */
    override suspend fun getIndividualNewsShots(postLink: String) = newsShotsRepo.getIndividualNewsShots(postLink = postLink)
}
