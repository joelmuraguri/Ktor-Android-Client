package com.joel.ktor_android_client_calls.data.paged_response.network

import com.joel.ktor_android_client_calls.common.HttpRoutes
import com.joel.ktor_android_client_calls.data.paged_response.dto.PopularDTO
import com.joel.ktor_android_client_calls.data.paged_response.dto.PopularResponse
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

class MovieApi @Inject constructor(
    private val client : HttpClient
) {

    suspend fun getPopularPagedResponse() : List<PopularDTO> {
        return client.get<PopularResponse> { url(HttpRoutes.POPULAR) }.results
    }


}