package com.apoorvgupta.core.threading

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlin.coroutines.CoroutineContext

/**
 * App dispatcher provider
 *
 * @constructor Create empty App dispatcher provider
 *
 * @author Apoorv Gupta
 */
class AppDispatcherProvider : DispatcherProvider {
    override val main: CoroutineContext = Dispatchers.Main
    override val io: CoroutineContext = Dispatchers.IO
    override val default: CoroutineContext = Dispatchers.Default
}
