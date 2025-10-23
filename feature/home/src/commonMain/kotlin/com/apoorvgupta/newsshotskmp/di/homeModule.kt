package com.apoorvgupta.newsshotskmp.di

import com.apoorvgupta.newsshotskmp.home.usecase.HomeScreenUseCase
import com.apoorvgupta.newsshotskmp.home.usecase.HomeScreenUseCaseImpl
import com.apoorvgupta.newsshotskmp.home.viewmodel.HomeViewModel
import com.apoorvgupta.newsshotskmp.newsshotsdetails.usecase.NewsDetailsScreenUseCase
import com.apoorvgupta.newsshotskmp.newsshotsdetails.usecase.NewsDetailsScreenUseCaseImpl
import com.apoorvgupta.newsshotskmp.newsshotsdetails.viewmodel.NewsDetailsViewModel
import com.apoorvgupta.newsshotskmp.newsshotslisting.viewmodel.NewsShotsListingViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val homeModule = module {
    singleOf(::HomeScreenUseCaseImpl).bind<HomeScreenUseCase>()
    singleOf(::NewsDetailsScreenUseCaseImpl).bind<NewsDetailsScreenUseCase>()

    viewModelOf(::HomeViewModel)
    viewModelOf(::NewsDetailsViewModel)
    viewModelOf(::NewsShotsListingViewModel)
}