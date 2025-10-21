package com.apoorvgupta.newsshotskmp.core.di

import com.apoorvgupta.newsshotskmp.core.threading.AppDispatcherProvider
import com.apoorvgupta.newsshotskmp.core.threading.DispatcherProvider
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreModule = module {
    singleOf(::AppDispatcherProvider).bind<DispatcherProvider>()
}