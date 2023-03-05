package com.joel.ktor_android_client_calls.presentation.movie

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joel.ktor_android_client_calls.common.ResourceResult
import com.joel.ktor_android_client_calls.domain.paged_response.model.PopularMovie
import com.joel.ktor_android_client_calls.domain.paged_response.use_case.PopularMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val useCase: PopularMovieUseCase
): ViewModel() {

    private val _state = mutableStateOf(MovieListState())
    val state : State<MovieListState> = _state

    init {
        getMovies()
    }


    private fun getMovies(){
        useCase().onEach { result ->
            when(result){
                is ResourceResult.Success -> {
                    _state.value = MovieListState(movies = result.data)
                }
                is ResourceResult.Loading -> {
                    _state.value = MovieListState(isLoading = true)

                }
                is ResourceResult.Error -> {
                    _state.value = MovieListState(
                        error = result.message
                    )
                }
                is ResourceResult.Empty -> TODO()
            }
        }.launchIn(viewModelScope)
    }
}

data class MovieListState(
    val isLoading: Boolean = false,
    val movies: List<PopularMovie> = emptyList(),
    val error: String = ""
)