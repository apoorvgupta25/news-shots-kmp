package com.apoorvgupta.datastore.mapper

import com.apoorvgupta.datastore.model.AppThemeOptions as DataStoreThemeOptions
import com.apoorvgupta.domain.model.AppThemeOptions as DomainThemeOptions

/**
 * Maps AppThemeOptions between Repository and DataStore.
 */
internal class AppThemeOptionsMapper {

    /**
     * Maps AppThemeOptions from DataStore to Domain.
     *
     * @param appThemeOptions the object to be converted
     *
     * @return the converted object
     */
    fun toDataStore(appThemeOptions: DomainThemeOptions): DataStoreThemeOptions = when (appThemeOptions) {
        DomainThemeOptions.LIGHT -> DataStoreThemeOptions.LIGHT
        DomainThemeOptions.DARK -> DataStoreThemeOptions.DARK
        DomainThemeOptions.SYSTEM -> DataStoreThemeOptions.SYSTEM
    }

    /**
     * Maps AppThemeOptions from DataStore to Repo.
     *
     * @param appThemeOptions the object to be converted
     *
     * @return the converted object
     */
    fun toRepo(appThemeOptions: DataStoreThemeOptions): DomainThemeOptions = when (appThemeOptions) {
        DataStoreThemeOptions.LIGHT -> DomainThemeOptions.LIGHT
        DataStoreThemeOptions.DARK -> DomainThemeOptions.DARK
        DataStoreThemeOptions.SYSTEM -> DomainThemeOptions.SYSTEM
    }
}
