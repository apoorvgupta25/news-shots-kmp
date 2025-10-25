package com.apoorvgupta.network.usecase

import com.apoorvgupta.domain.repo.NewsShotsRepo
import com.apoorvgupta.domain.usecase.GetAllNewsShotsUseCase

/**
 * @author Apoorv Gupta
 */

class GetAllNewsShotsUseCaseImpl(
    private val newsShotsRepo: NewsShotsRepo,
) : GetAllNewsShotsUseCase {

    override fun getAllNewsShots() = newsShotsRepo.getAllNewsShots()
}
