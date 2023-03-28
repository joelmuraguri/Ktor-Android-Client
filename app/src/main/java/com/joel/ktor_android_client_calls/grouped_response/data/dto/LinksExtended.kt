package com.joel.ktor_android_client_calls.grouped_response.data.dto

@kotlinx.serialization.Serializable
data class LinksExtended(
    val stats: Stats ? = null,
    val type: String ? = null,
    val url: String ? = null
)