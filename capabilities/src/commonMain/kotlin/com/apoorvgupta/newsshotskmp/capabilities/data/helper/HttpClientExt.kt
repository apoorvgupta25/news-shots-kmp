package com.apoorvgupta.newsshotskmp.capabilities.data.helper

import com.apoorvgupta.newsshotskmp.core.domain.DataError
import com.apoorvgupta.newsshotskmp.core.domain.Result
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.ensureActive
import kotlin.coroutines.coroutineContext

/**
 * @author Apoorv Gupta
 */

suspend inline fun <reified T> safeCall(
    execute: () -> HttpResponse
): Result<T, DataError.Remote> {
    val response = try {
        execute()
    } catch(e: SocketTimeoutException) {
        return Result.Error(DataError.Remote.REQUEST_TIMEOUT)
    } catch(e: UnresolvedAddressException) {
        return Result.Error(DataError.Remote.NO_INTERNET)
    } catch (e: Exception) {
        coroutineContext.ensureActive()
        return Result.Error(DataError.Remote.UNKNOWN)
    }

    return responseToResult(response)
}

suspend inline fun <reified T> responseToResult(
    response: HttpResponse
): Result<T, DataError.Remote> {
    return when(response.status.value) {
        in 200..299 -> {
            try {
                Result.Success(response.body<T>())
            } catch(e: NoTransformationFoundException) {
                Result.Error(DataError.Remote.SERIALIZATION, response.status.value)
            }
        }
        408 -> Result.Error(DataError.Remote.REQUEST_TIMEOUT, response.status.value)
        429 -> Result.Error(DataError.Remote.TOO_MANY_REQUESTS, response.status.value)
        in 500..599 -> Result.Error(DataError.Remote.SERVER, response.status.value)
        else -> Result.Error(DataError.Remote.UNKNOWN, response.status.value)
    }
}