package com.apoorvgupta.home.di

import com.apoorvgupta.home.usecase.HomeScreenUseCase
import com.apoorvgupta.home.usecase.HomeScreenUseCaseImpl
import com.apoorvgupta.home.viewmodel.HomeViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val homeModule = module {
    singleOf(::HomeScreenUseCaseImpl).bind<HomeScreenUseCase>()

    viewModelOf(::HomeViewModel)
}