package com.apoorvgupta.newsshotskmp

import androidx.compose.ui.window.ComposeUIViewController
import com.apoorvgupta.newsshotskmp.core.logger.AppLogger

@Suppress("FunctionName")
fun MainViewController() = ComposeUIViewController(
    configure = {
        AppLogger.enableLogging()
    }
) {
    App()
}