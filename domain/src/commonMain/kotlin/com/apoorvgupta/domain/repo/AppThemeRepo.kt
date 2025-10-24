package com.apoorvgupta.domain.repo

import com.apoorvgupta.domain.model.AppThemeOptions
import kotlinx.coroutines.flow.Flow

/**
 * @author Apoorv Gupta
 */

interface AppThemeRepo {

    /**
     * Updates the current app theme.
     *
     * @param theme the theme to be updated
     */
    suspend fun updateAppTheme(theme: AppThemeOptions)

    /**
     * Loads the current app theme.
     *
     * @return flow of [com.apoorvgupta.domain.model.AppThemeOptions]
     */
    fun loadAppTheme(): Flow<AppThemeOptions>
}