package com.apoorvgupta.datastore.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.apoorvgupta.datastore.AndroidDataStore
import org.koin.dsl.module

internal actual val platformDataStoreModule = module {
    single<DataStore<Preferences>> { AndroidDataStore(context = get()).getDataStore() }
}
