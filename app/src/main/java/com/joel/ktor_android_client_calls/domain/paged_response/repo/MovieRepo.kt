package com.joel.ktor_android_client_calls.domain.paged_response.repo

import com.joel.ktor_android_client_calls.data.paged_response.dto.PopularDTO

interface MovieRepo {

    suspend fun getPopularMovies() : List<PopularDTO>


}