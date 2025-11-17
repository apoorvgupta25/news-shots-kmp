package com.apoorvgupta.domain.usecase.datastore

import com.apoorvgupta.domain.model.AppThemeOptions
import kotlinx.coroutines.flow.Flow

/**
 * Loads the current app theme.
 *
 * @property LoadAppThemeUseCase the AppTheme Usecase
 *
 * @author Apoorv Gupta
 */
fun interface LoadAppThemeUseCase {
    operator fun invoke(): Flow<AppThemeOptions>
}
