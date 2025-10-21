package com.apoorvgupta.newsshotskmp.capabilities.data.usecase

import com.apoorvgupta.newsshotskmp.capabilities.domain.repo.NewsShotsRepo
import com.apoorvgupta.newsshotskmp.capabilities.domain.usecase.GetAllCategoriesUseCase

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
    override suspend fun getAllCategories() = newsShotsRepo.getCategories()
}
