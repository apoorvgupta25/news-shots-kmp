package com.apoorvgupta.newsshotskmp.capabilities.data.usecase

import com.apoorvgupta.newsshotskmp.capabilities.domain.repo.NewsShotsRepo
import com.apoorvgupta.newsshotskmp.capabilities.domain.usecase.GetAllNewsShotsUseCase

/**
 * @author Apoorv Gupta
 */

class GetAllNewsShotsUseCaseImpl(
    private val newsShotsRepo: NewsShotsRepo,
) : GetAllNewsShotsUseCase {

    override fun getAllNewsShots() = newsShotsRepo.getAllNewsShots()
}
