package com.apoorvgupta.newsshotslisting.di

import com.apoorvgupta.newsshotslisting.viewmodel.NewsShotsListingViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val listingModule = module {
    viewModelOf(::NewsShotsListingViewModel)
}