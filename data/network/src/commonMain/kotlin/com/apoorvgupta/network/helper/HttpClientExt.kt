package com.apoorvgupta.network.helper

import com.apoorvgupta.core.model.DataError
import com.apoorvgupta.core.model.Result
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
    execute: () -> HttpResponse,
): Result<T, DataError.Remote> {
    val result: Result<T, DataError.Remote> = try {
        val response = execute()
        responseToResult(response)
    } catch (e: SocketTimeoutException) {
        Result.Error(DataError.Remote.REQUEST_TIMEOUT)
    } catch (e: UnresolvedAddressException) {
        Result.Error(DataError.Remote.NO_INTERNET)
    } catch (e: Exception) {
        coroutineContext.ensureActive()
        Result.Error(DataError.Remote.UNKNOWN)
    }

    return result
}

suspend inline fun <reified T> responseToResult(
    response: HttpResponse,
): Result<T, DataError.Remote> = when (response.status.value) {
    in Constants.SUCCESS_RESPONSE_START..Constants.SUCCESS_RESPONSE_END -> {
        try {
            Result.Success(data = response.body<T>())
        } catch (e: NoTransformationFoundException) {
            Result.Error(error = DataError.Remote.SERIALIZATION, statusCode = response.status.value)
        }
    }

    Constants.TIMEOUT_RESPONSE -> Result.Error(
        error = DataError.Remote.REQUEST_TIMEOUT,
        statusCode = response.status.value,
    )

    Constants.TOO_MANY_RESPONSE -> Result.Error(
        error = DataError.Remote.TOO_MANY_REQUESTS,
        statusCode = response.status.value,
    )

    in Constants.ERROR_RESPONSE_START..Constants.ERROR_RESPONSE_END -> Result.Error(
        error = DataError.Remote.SERVER,
        statusCode = response.status.value,
    )

    else -> Result.Error(
        error = DataError.Remote.UNKNOWN,
        statusCode = response.status.value,
    )
}
