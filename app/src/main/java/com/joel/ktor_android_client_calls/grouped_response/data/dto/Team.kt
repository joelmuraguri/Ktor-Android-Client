package com.joel.ktor_android_client_calls.grouped_response.data.dto

@kotlinx.serialization.Serializable
data class Team(
    val id: String,
    val name: String,
    val position: String
)