package com.apoorvgupta.newsshotskmp.di

import com.apoorvgupta.newsshotskmp.home.navigation.HomeScreenUseCase
import com.apoorvgupta.newsshotskmp.home.usecase.HomeScreenUseCaseImpl
import com.apoorvgupta.newsshotskmp.home.viewmodel.HomeViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val homeModule = module {
    singleOf(::HomeScreenUseCaseImpl).bind<HomeScreenUseCase>()

    viewModelOf(::HomeViewModel)
}