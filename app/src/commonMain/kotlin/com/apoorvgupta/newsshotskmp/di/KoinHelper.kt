package com.apoorvgupta.newsshotskmp.di

import com.apoorvgupta.core.di.coreModule
import com.apoorvgupta.coroutines.di.coroutinesModule
import com.apoorvgupta.datastore.di.dataStoreModule
import com.apoorvgupta.home.di.homeModule
import com.apoorvgupta.network.di.networkModule
import com.apoorvgupta.newsshotsdetails.di.detailsModule
import com.apoorvgupta.newsshotslisting.di.listingModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

/**
 * @author Apoorv Gupta
 */

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            modules,
        )
    }
}

internal val modules = listOf(
    appModule,
    coreModule,
    coroutinesModule,
    networkModule,
    homeModule,
    detailsModule,
    listingModule,
    dataStoreModule,
)
