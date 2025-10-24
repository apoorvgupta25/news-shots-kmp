package com.apoorvgupta.domain.usecase.datastore

import com.apoorvgupta.domain.model.AppThemeOptions
import kotlinx.coroutines.flow.Flow

/**
 * Loads the current app theme.
 *
 * @property appThemeRepo the AppTheme repository
 *
 * @author Apoorv Gupta
 */
interface LoadAppThemeUseCase {
    operator fun invoke(): Flow<AppThemeOptions>
}
