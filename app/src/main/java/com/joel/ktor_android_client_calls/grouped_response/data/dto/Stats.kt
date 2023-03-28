package com.joel.ktor_android_client_calls.grouped_response.data.dto

@kotlinx.serialization.Serializable
data class Stats(
    val contributors: Int ? = null,
    val followers: Int ? = null,
    val stars: Int ? = null,
    val subscribers: Int ? = null
)