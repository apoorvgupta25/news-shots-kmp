package com.apoorvgupta.newsshotskmp.di

import com.apoorvgupta.core.interactions.buildConfigProvider.BuildConfigContract
import com.apoorvgupta.newsshotskmp.AppViewModel
import com.apoorvgupta.newsshotskmp.BuildConfigContractImpl
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * @author Apoorv Gupta
 */

val appModule = module {
    singleOf(::BuildConfigContractImpl).bind<BuildConfigContract>()
    viewModelOf(::AppViewModel)
}
