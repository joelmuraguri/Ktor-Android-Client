package com.joel.ktor_android_client_calls.domain.paged_response.use_case

import com.joel.ktor_android_client_calls.common.ResourceResult
import com.joel.ktor_android_client_calls.domain.paged_response.model.PopularMovie
import com.joel.ktor_android_client_calls.domain.paged_response.repo.MovieRepo
import io.ktor.client.features.*
import io.ktor.network.sockets.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PopularMovieUseCase @Inject constructor(
    private val repo: MovieRepo
) {


    operator fun invoke() : Flow<ResourceResult<List<PopularMovie>>> = flow {
        try {
            emit(ResourceResult.Loading(true))
            val movies = repo.getPopularMovies().map { it.toPopularMovie() }
            emit(ResourceResult.Success(movies))
        } catch ( e: ServerResponseException){
            emit(ResourceResult.Error(e.toString()))
        } catch ( e: ConnectTimeoutException){
            emit(ResourceResult.Error(e.toString()))
        } catch ( e: Exception){
            emit(ResourceResult.Error(e.toString()))
        }
    }

}