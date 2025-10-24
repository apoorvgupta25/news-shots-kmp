package com.apoorvgupta.domain.usecase.datastore

import com.apoorvgupta.domain.model.AppThemeOptions

/**
 * Updates the current app theme.
 *
 * @property appThemeRepo the AppTheme repository
 *
 * @author Apoorv Gupta
 */
interface UpdateAppThemeUseCase {
    suspend operator fun invoke(theme: AppThemeOptions)
}
