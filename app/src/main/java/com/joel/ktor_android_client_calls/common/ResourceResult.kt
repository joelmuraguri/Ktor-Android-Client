package com.joel.ktor_android_client_calls.common

sealed class ResourceResult<T>(val data : T ? = null, val message : String ?= null){

    class Success<T>(data: T) : ResourceResult<T>(data)
    class Loading<T>(data: T ? =  null) : ResourceResult<T>(data)
    class Error<T>(message: String, data: T? = null) : ResourceResult<T>(data, message)

}


