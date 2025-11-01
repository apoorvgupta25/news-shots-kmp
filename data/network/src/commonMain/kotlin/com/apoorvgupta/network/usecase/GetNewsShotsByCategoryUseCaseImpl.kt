package com.apoorvgupta.network.usecase

import com.apoorvgupta.domain.repo.NewsShotsRepo
import com.apoorvgupta.domain.usecase.GetNewsShotsByCategoryUseCase

/**
 * Get news shots by category use case impl
 *
 * @property newsShotsRepo
 * @constructor Create empty Get news shots by category use case impl
 *
 * @author Apoorv Gupta
 */
class GetNewsShotsByCategoryUseCaseImpl(
    private val newsShotsRepo: NewsShotsRepo,
) : GetNewsShotsByCategoryUseCase {

    /**
     * Get news shots by category
     *
     * @param categoryName
     * @return
     */
    override operator fun invoke(categoryName: String) =
        newsShotsRepo.getNewsShotsByCategory(categoryName = categoryName)
}
