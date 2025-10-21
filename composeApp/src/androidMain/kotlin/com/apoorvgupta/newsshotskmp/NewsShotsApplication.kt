package com.apoorvgupta.newsshotskmp

import android.app.Application
import com.apoorvgupta.newsshotskmp.core.logger.AppLogger

/**
 * @author Apoorv Gupta
 */
class NewsShotsApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        AppLogger.enableLogging()
    }
}