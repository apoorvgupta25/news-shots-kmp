package com.apoorvgupta.core.di

import com.apoorvgupta.core.threading.AppDispatcherProvider
import com.apoorvgupta.core.threading.DispatcherProvider
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreModule = module {
    singleOf(::AppDispatcherProvider).bind<DispatcherProvider>()
}