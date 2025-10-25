package com.apoorvgupta.coroutines.di

import com.apoorvgupta.coroutines.AppCoroutineScope
import com.apoorvgupta.coroutines.CoroutineDebouncer
import com.apoorvgupta.coroutines.CoroutineDebouncerImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * Coroutines library dependency injection module.
 */
val coroutinesModule = module {
    single { AppCoroutineScope() }
    factoryOf(::CoroutineDebouncerImpl) bind CoroutineDebouncer::class
}
