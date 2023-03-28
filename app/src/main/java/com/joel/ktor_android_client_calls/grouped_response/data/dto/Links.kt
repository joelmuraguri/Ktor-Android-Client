package com.joel.ktor_android_client_calls.grouped_response.data.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Links(
    val explorer: List<String>,
    val facebook: List<String>,
    val reddit: List<String>,
    @SerialName("source_code")
    val sourceCode: List<String> ? = emptyList(),
    val website: List<String>,
    val youtube: List<String>
)