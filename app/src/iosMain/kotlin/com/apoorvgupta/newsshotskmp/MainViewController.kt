package com.apoorvgupta.newsshotskmp

import androidx.compose.ui.window.ComposeUIViewController
import com.apoorvgupta.core.logger.AppLogger
import com.apoorvgupta.newsshotskmp.di.initKoin

@Suppress("FunctionName")
fun MainViewController() = ComposeUIViewController(
    configure = {
        AppLogger.enableLogging()

        initKoin()
    }
) {
    App()
}