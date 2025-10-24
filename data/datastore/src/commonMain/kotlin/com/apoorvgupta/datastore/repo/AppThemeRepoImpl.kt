package com.apoorvgupta.datastore.repo

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import com.apoorvgupta.datastore.mapper.AppThemeOptionsMapper
import com.apoorvgupta.domain.repo.AppThemeRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.apoorvgupta.datastore.model.AppThemeOptions as DataStoreThemeOptions
import com.apoorvgupta.domain.model.AppThemeOptions as DomainThemeOptions

/**
 * @author Apoorv Gupta
 */
internal class AppThemeRepoImpl(
    private val dataStore: DataStore<Preferences>,
    private val mapper: AppThemeOptionsMapper,
) : AppThemeRepo {

    override suspend fun updateAppTheme(theme: DomainThemeOptions) {
        dataStore.edit { settings ->
            settings[APP_THEME_OPTION] = mapper.toDataStore(theme).id
        }
    }

    override fun loadAppTheme(): Flow<DomainThemeOptions> = dataStore.data.map { preferences ->
        val id = preferences[APP_THEME_OPTION] ?: DataStoreThemeOptions.SYSTEM.id
        val result =
            DataStoreThemeOptions.entries.find { it.id == id } ?: DataStoreThemeOptions.SYSTEM
        mapper.toRepo(result)
    }

    private companion object {
        val APP_THEME_OPTION = intPreferencesKey("newsshots_theme_option")
    }
}
