package com.joel.ktor_android_client_calls.common

import android.util.Log
import io.ktor.client.call.*
import io.ktor.client.features.*
import io.ktor.network.sockets.*

@Deprecated("Use dataResultSafeApiCall")
suspend fun <T> safeApiCall(block: suspend () -> T): T {
    try {
        return block()
    } catch (e: Exception) {
        Log.d("EXCEPTION", e.message.toString())
        when (e) {
            is ServerResponseException, is NoTransformationFoundException -> {
                throw ServerError(e)
            }
            is ConnectTimeoutException -> {
                throw NetworkError()
            }
            else -> throw e
        }
    }
}

class ServerError(cause: Throwable) : Exception(cause)
class NetworkError : Exception()

suspend fun <T : Any> dataResultSafeApiCall(
    apiCall: suspend () -> T
): DataResult<T> = try {
    DataResult.Success(apiCall.invoke())
} catch (throwable: Throwable) {
    Log.d("ERROR",throwable.message.toString())
    when (throwable) {
        is ServerResponseException, is NoTransformationFoundException -> {
            DataResult.Error("Server error", exc = throwable)
        }
        is ConnectTimeoutException -> {
            DataResult.Error("Network error", exc = throwable, networkError = true)
        }
        else -> {
            DataResult.Error("Client error", exc = throwable)
        }
    }
}