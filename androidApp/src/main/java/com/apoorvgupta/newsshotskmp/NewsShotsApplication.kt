package com.apoorvgupta.newsshotskmp

import android.app.Application
import com.apoorvgupta.core.logger.AppLogger
import com.apoorvgupta.newsshotskmp.di.initKoin
import org.koin.android.ext.koin.androidContext

/**
 * @author Apoorv Gupta
 */
class NewsShotsApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        AppLogger.enableLogging()

        initKoin {
            androidContext(this@NewsShotsApplication)
        }
    }
}
