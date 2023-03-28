package com.joel.ktor_android_client_calls.grouped_response.data.dto

data class Links(
    val explorer: List<String>,
    val facebook: List<String>,
    val reddit: List<String>,
    val source_code: List<String>,
    val website: List<String>,
    val youtube: List<String>
)