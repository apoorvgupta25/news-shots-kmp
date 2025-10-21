package com.apoorvgupta.newsshotskmp.capabilities.data.usecase

import com.apoorvgupta.newsshotskmp.capabilities.domain.repo.NewsShotsRepo
import com.apoorvgupta.newsshotskmp.capabilities.domain.usecase.GetSearchedNewsShotsUseCase

/**
 * Get searched news shots use case impl
 *
 * @property newsShotsRepo
 * @constructor Create empty Get searched news shots use case impl
 *
 * @author Apoorv Gupta
 */
class GetSearchedNewsShotsUseCaseImpl (
    private val newsShotsRepo: NewsShotsRepo,
) : GetSearchedNewsShotsUseCase {

    /**
     * Get searched news shots
     *
     * @param searchKeyword
     * @return
     */
    override suspend fun getSearchedNewsShots(searchKeyword: String) = newsShotsRepo.getSearchedNewsShots(searchKeyword = searchKeyword)
}
