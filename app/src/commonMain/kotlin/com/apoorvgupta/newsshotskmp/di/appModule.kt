package com.apoorvgupta.newsshotskmp.di

import com.apoorvgupta.newsshotskmp.BuildConfigContractImpl
import com.apoorvgupta.core.interactions.buildConfigProvider.BuildConfigContract
import com.apoorvgupta.core.threading.AppDispatcherProvider
import com.apoorvgupta.core.threading.DispatcherProvider
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * @author Apoorv Gupta
 */

val appModule = module {
    singleOf(::BuildConfigContractImpl).bind<BuildConfigContract>()
}