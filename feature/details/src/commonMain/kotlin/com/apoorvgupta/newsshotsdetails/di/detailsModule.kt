package com.apoorvgupta.newsshotsdetails.di

import com.apoorvgupta.newsshotsdetails.usecase.NewsDetailsScreenUseCase
import com.apoorvgupta.newsshotsdetails.usecase.NewsDetailsScreenUseCaseImpl
import com.apoorvgupta.newsshotsdetails.viewmodel.NewsDetailsViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val detailsModule = module {
    singleOf(::NewsDetailsScreenUseCaseImpl).bind<NewsDetailsScreenUseCase>()

    viewModelOf(::NewsDetailsViewModel)
}