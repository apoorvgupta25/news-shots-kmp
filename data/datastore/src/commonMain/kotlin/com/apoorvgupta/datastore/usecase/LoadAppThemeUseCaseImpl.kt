package com.apoorvgupta.datastore.usecase

import com.apoorvgupta.domain.model.AppThemeOptions
import com.apoorvgupta.domain.repo.AppThemeRepo
import com.apoorvgupta.domain.usecase.datastore.LoadAppThemeUseCase
import kotlinx.coroutines.flow.Flow

/**
 * Loads the current app theme.
 *
 * @property appThemeRepo the AppTheme repository
 *
 * @author Apoorv Gupta
 */
class LoadAppThemeUseCaseImpl(private val appThemeRepo: AppThemeRepo) : LoadAppThemeUseCase {
    override operator fun invoke(): Flow<AppThemeOptions> = appThemeRepo.loadAppTheme()
}
