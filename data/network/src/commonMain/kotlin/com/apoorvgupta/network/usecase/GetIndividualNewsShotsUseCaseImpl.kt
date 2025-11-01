package com.apoorvgupta.network.usecase

import com.apoorvgupta.domain.repo.NewsShotsRepo
import com.apoorvgupta.domain.usecase.GetIndividualNewsShotsUseCase

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
    override suspend operator fun invoke(postLink: String) = newsShotsRepo.getIndividualNewsShots(postLink = postLink)
}
