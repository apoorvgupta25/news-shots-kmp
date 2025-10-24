package com.apoorvgupta.newsshotskmp.capabilities.di

import com.apoorvgupta.newsshotskmp.capabilities.data.network.HttpClientFactory
import com.apoorvgupta.newsshotskmp.capabilities.data.network.RemoteNewsShotsDataSource
import com.apoorvgupta.newsshotskmp.capabilities.data.network.RemoteNewsShotsDataSourceImpl
import com.apoorvgupta.newsshotskmp.capabilities.data.repo.NewsShotsRepoImpl
import com.apoorvgupta.newsshotskmp.capabilities.data.usecase.GetAllCategoriesUseCaseImpl
import com.apoorvgupta.newsshotskmp.capabilities.data.usecase.GetAllNewsShotsUseCaseImpl
import com.apoorvgupta.newsshotskmp.capabilities.data.usecase.GetIndividualNewsShotsUseCaseImpl
import com.apoorvgupta.newsshotskmp.capabilities.data.usecase.GetNewsShotsByCategoryUseCaseImpl
import com.apoorvgupta.newsshotskmp.capabilities.data.usecase.GetRecentNewsShotsUseCaseImpl
import com.apoorvgupta.newsshotskmp.capabilities.data.usecase.GetSearchedNewsShotsUseCaseImpl
import com.apoorvgupta.domain.repo.NewsShotsRepo
import com.apoorvgupta.domain.usecase.GetAllCategoriesUseCase
import com.apoorvgupta.domain.usecase.GetAllNewsShotsUseCase
import com.apoorvgupta.domain.usecase.GetIndividualNewsShotsUseCase
import com.apoorvgupta.domain.usecase.GetNewsShotsByCategoryUseCase
import com.apoorvgupta.domain.usecase.GetRecentNewsShotsUseCase
import com.apoorvgupta.domain.usecase.GetSearchedNewsShotsUseCase
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val capabilitiesModule = module {
    single { HttpClientFactory.create(get()) }

    singleOf(::RemoteNewsShotsDataSourceImpl).bind<RemoteNewsShotsDataSource>()
    singleOf(::NewsShotsRepoImpl).bind<NewsShotsRepo>()

    singleOf(::GetAllCategoriesUseCaseImpl).bind<GetAllCategoriesUseCase>()
    singleOf(::GetIndividualNewsShotsUseCaseImpl).bind<GetIndividualNewsShotsUseCase>()
    singleOf(::GetRecentNewsShotsUseCaseImpl).bind<GetRecentNewsShotsUseCase>()
    singleOf(::GetSearchedNewsShotsUseCaseImpl).bind<GetSearchedNewsShotsUseCase>()
    singleOf(::GetNewsShotsByCategoryUseCaseImpl).bind<GetNewsShotsByCategoryUseCase>()
    singleOf(::GetAllNewsShotsUseCaseImpl).bind<GetAllNewsShotsUseCase>()

}