package com.apoorvgupta.newsshotskmp.capabilities.data.usecase

import com.apoorvgupta.newsshotskmp.capabilities.domain.repo.NewsShotsRepo
import com.apoorvgupta.newsshotskmp.capabilities.domain.usecase.GetNewsShotsByCategoryUseCase

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
    override fun getNewsShotsByCategory(categoryName: String) =
        newsShotsRepo.getNewsShotsByCategory(categoryName = categoryName)
//        .transform { response ->
//        emit(response)
//    }
}
