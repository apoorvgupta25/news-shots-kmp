package com.apoorvgupta.core.logger

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

/**
 * Logger provides a simple logging mechanism for tracking events
 * and debugging information in the application.
 *
 * @author Apoorv Gupta
 */
object AppLogger {

    /**
     * Enable logs for build variant
     * Do not use Logger in release variant
     */
    fun enableLogging() {
        d { "Logger is enabled" }
        Napier.base(DebugAntilog())
    }

    /**
     * Clears all debugging trees previously planted
     * and disables logs
     */
    fun disableLogging() {
        d { "Logger is disabled" }
        Napier.takeLogarithm()
    }

    private fun getTagName(tag: String = ""): String = tag

    /**
     * Logs a debug message using a lambda function.
     */
    fun d(message: () -> String) {
        Napier.d { message() }
    }

    /**
     * Logs a debug message using Timber with optional tag, message, and throwable.
     */
    fun d(
        tag: String = getTagName(),
        message: () -> String,
        throwable: Throwable? = null,
    ) {
        Napier.d(tag = tag, message = message, throwable = throwable)
    }

    /**
     * Logs a error message using Timber with optional tag, message, and throwable.
     */
    fun e(
        tag: String = getTagName(),
        message: () -> String,
        throwable: Throwable? = null,
    ) {
        Napier.e(tag = tag, message = message, throwable = throwable)
    }

    /**
     * Logs a info message using Timber with optional tag, message, and throwable.
     */
    fun i(
        tag: String = getTagName(),
        message: () -> String,
        throwable: Throwable? = null,
    ) {
        Napier.i(tag = tag, message = message, throwable = throwable)
    }

    /**
     * Logs a verbose message using Timber with optional tag, message, and throwable.
     */
    fun v(
        tag: String = getTagName(),
        message: () -> String,
        throwable: Throwable? = null,
    ) {
        Napier.v(tag = tag, message = message, throwable = throwable)
    }

    /**
     * Logs a warn message using Timber with optional tag, message, and throwable.
     */
    fun w(
        tag: String = getTagName(),
        message: () -> String,
        throwable: Throwable? = null,
    ) {
        Napier.w(tag = tag, message = message, throwable = throwable)
    }
}
