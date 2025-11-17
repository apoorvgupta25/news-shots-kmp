package com.apoorvgupta.domain.usecase.datastore

import com.apoorvgupta.domain.model.AppThemeOptions

/**
 * Updates the current app theme.
 *
 * @property UpdateAppThemeUseCase the AppTheme usecase
 *
 * @author Apoorv Gupta
 */
fun interface UpdateAppThemeUseCase {
    suspend operator fun invoke(theme: AppThemeOptions)
}
