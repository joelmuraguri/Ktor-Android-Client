package com.joel.ktor_android_client_calls.grouped_response.presentation.views

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joel.ktor_android_client_calls.common.HttpRoutes
import com.joel.ktor_android_client_calls.common.ResourceResult
import com.joel.ktor_android_client_calls.grouped_response.domain.use_case.GetCoinDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinDetailsUseCase: GetCoinDetailsUseCase,
    savedStateHandle: SavedStateHandle

) : ViewModel() {

    private val _coinDetailState = mutableStateOf(CoinDetailState())
    val coinDetailState : State<CoinDetailState> = _coinDetailState


    init {
        savedStateHandle.get<String>(HttpRoutes.PARAM_COIN_ID)?.let { coinId ->
            getCoinsDetails(coinId)
        }
    }

    fun getCoinsDetails(coinId : String){
        viewModelScope.launch {
            getCoinDetailsUseCase(coinId).onEach { result ->
                when(result){
                    is ResourceResult.Error -> {
                        _coinDetailState.value = CoinDetailState(
                            message = result.message ?: "An unexpected error occurred"
                        )
                    }
                    is ResourceResult.Loading -> {
                        _coinDetailState.value = CoinDetailState(
                            isLoading = true
                        )
                    }
                    is ResourceResult.Success -> {
                        _coinDetailState.value = CoinDetailState(
                            details = result.data
                        )
                    }
                }
            }.launchIn(viewModelScope)
        }
    }

}