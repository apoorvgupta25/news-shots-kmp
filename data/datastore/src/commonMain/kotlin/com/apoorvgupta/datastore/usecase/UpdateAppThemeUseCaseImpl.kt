package com.apoorvgupta.datastore.usecase

import com.apoorvgupta.domain.model.AppThemeOptions
import com.apoorvgupta.domain.repo.AppThemeRepo
import com.apoorvgupta.domain.usecase.datastore.UpdateAppThemeUseCase

/**
 * Updates the current app theme.
 *
 * @property appThemeRepo the AppTheme repository
 *
 * @author Apoorv Gupta
 */
class UpdateAppThemeUseCaseImpl(
    private val appThemeRepo: AppThemeRepo
) : UpdateAppThemeUseCase {
    override suspend operator fun invoke(theme: AppThemeOptions) =
        appThemeRepo.updateAppTheme(theme)
}