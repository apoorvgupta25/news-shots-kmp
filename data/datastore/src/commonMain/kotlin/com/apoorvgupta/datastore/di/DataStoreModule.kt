package com.apoorvgupta.datastore.di

import com.apoorvgupta.datastore.mapper.AppThemeOptionsMapper
import com.apoorvgupta.datastore.repo.AppThemeRepoImpl
import com.apoorvgupta.datastore.usecase.LoadAppThemeUseCaseImpl
import com.apoorvgupta.datastore.usecase.UpdateAppThemeUseCaseImpl
import com.apoorvgupta.domain.repo.AppThemeRepo
import com.apoorvgupta.domain.usecase.datastore.LoadAppThemeUseCase
import com.apoorvgupta.domain.usecase.datastore.UpdateAppThemeUseCase
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * DataStore dependency injection module.
 */
val dataStoreModule = module {

    // Repo
    singleOf(::AppThemeRepoImpl) bind AppThemeRepo::class

    // Usecase
    singleOf(::LoadAppThemeUseCaseImpl) bind LoadAppThemeUseCase::class
    singleOf(::UpdateAppThemeUseCaseImpl) bind UpdateAppThemeUseCase::class

    // Mappers
    factoryOf(::AppThemeOptionsMapper)

    includes(platformDataStoreModule)
}

/**
 * Provides the platform-specific dependencies.
 */
internal expect val platformDataStoreModule: Module
