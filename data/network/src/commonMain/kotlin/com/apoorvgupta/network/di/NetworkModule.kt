package com.apoorvgupta.network.di

import com.apoorvgupta.domain.repo.NewsShotsRepo
import com.apoorvgupta.domain.usecase.GetAllCategoriesUseCase
import com.apoorvgupta.domain.usecase.GetAllNewsShotsUseCase
import com.apoorvgupta.domain.usecase.GetIndividualNewsShotsUseCase
import com.apoorvgupta.domain.usecase.GetNewsShotsByCategoryUseCase
import com.apoorvgupta.domain.usecase.GetRecentNewsShotsUseCase
import com.apoorvgupta.domain.usecase.GetSearchedNewsShotsUseCase
import com.apoorvgupta.network.datasource.HttpClientFactory
import com.apoorvgupta.network.datasource.RemoteNewsShotsDataSource
import com.apoorvgupta.network.datasource.RemoteNewsShotsDataSourceImpl
import com.apoorvgupta.network.repo.NewsShotsRepoImpl
import com.apoorvgupta.network.usecase.GetAllCategoriesUseCaseImpl
import com.apoorvgupta.network.usecase.GetAllNewsShotsUseCaseImpl
import com.apoorvgupta.network.usecase.GetIndividualNewsShotsUseCaseImpl
import com.apoorvgupta.network.usecase.GetNewsShotsByCategoryUseCaseImpl
import com.apoorvgupta.network.usecase.GetRecentNewsShotsUseCaseImpl
import com.apoorvgupta.network.usecase.GetSearchedNewsShotsUseCaseImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * @author Apoorv Gupta
 */

val networkModule = module {
    single { HttpClientFactory.create(get()) }

    singleOf(::RemoteNewsShotsDataSourceImpl).bind<RemoteNewsShotsDataSource>()
    singleOf(::NewsShotsRepoImpl).bind<NewsShotsRepo>()

    singleOf(::GetAllCategoriesUseCaseImpl).bind<GetAllCategoriesUseCase>()
    singleOf(::GetIndividualNewsShotsUseCaseImpl).bind<GetIndividualNewsShotsUseCase>()
    singleOf(::GetRecentNewsShotsUseCaseImpl).bind<GetRecentNewsShotsUseCase>()
    singleOf(::GetSearchedNewsShotsUseCaseImpl).bind<GetSearchedNewsShotsUseCase>()
    singleOf(::GetNewsShotsByCategoryUseCaseImpl).bind<GetNewsShotsByCategoryUseCase>()
    singleOf(::GetAllNewsShotsUseCaseImpl).bind<GetAllNewsShotsUseCase>()

    includes(platformModule)
}

internal expect val platformModule: Module
