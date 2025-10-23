package com.apoorvgupta.newsshotskmp.di

import com.apoorvgupta.newsshotskmp.capabilities.di.capabilitiesModule
import com.apoorvgupta.newsshotskmp.capabilities.di.platformModule
import com.apoorvgupta.newsshotskmp.core.di.coreModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

/**
 * @author Apoorv Gupta
 */

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            appModule,
            coreModule,
            platformModule,
            capabilitiesModule,
            homeModule
        )
    }
}