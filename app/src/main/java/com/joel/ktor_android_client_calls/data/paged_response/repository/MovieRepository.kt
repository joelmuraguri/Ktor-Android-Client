package com.joel.ktor_android_client_calls.data.paged_response.repository

import com.joel.ktor_android_client_calls.data.paged_response.dto.PopularDTO
import com.joel.ktor_android_client_calls.data.paged_response.network.MovieApi
import com.joel.ktor_android_client_calls.domain.paged_response.model.PopularMovie
import com.joel.ktor_android_client_calls.domain.paged_response.repo.MovieRepo
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val api : MovieApi
): MovieRepo {

    override suspend fun getPopularMovies(): List<PopularDTO> {
        return api.getPopularPagedResponse()
    }

}