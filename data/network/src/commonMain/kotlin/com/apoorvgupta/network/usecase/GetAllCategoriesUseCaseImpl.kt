package com.apoorvgupta.network.usecase

import com.apoorvgupta.domain.repo.NewsShotsRepo
import com.apoorvgupta.domain.usecase.GetAllCategoriesUseCase

/**
 * @author Apoorv Gupta
 */
class GetAllCategoriesUseCaseImpl(
    private val newsShotsRepo: NewsShotsRepo,
) : GetAllCategoriesUseCase {

    /**
     * Gets all categories.
     *
     * @return the flow
     */
    override suspend operator fun invoke() = newsShotsRepo.getCategories()
}
