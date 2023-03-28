package com.joel.ktor_android_client_calls.grouped_response.presentation.views

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joel.ktor_android_client_calls.common.ResourceResult
import com.joel.ktor_android_client_calls.grouped_response.domain.use_case.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _coinsState = mutableStateOf(CoinListState())
    val coinsState : State<CoinListState> = _coinsState

    init {
        getCoins()
    }

    fun getCoins(){
        viewModelScope.launch {
            getCoinsUseCase().onEach { result ->
                when(result){
                    is ResourceResult.Error -> {
                        _coinsState.value = CoinListState(
                            error = result.message ?: "An unxpected Error Occurred "
                        )
                    }
                    is ResourceResult.Loading -> {
                        _coinsState.value = CoinListState(
                            isLoading = true
                        )
                    }
                    is ResourceResult.Success -> {
                        _coinsState.value = CoinListState(
                            coins = result.data ?: emptyList()
                        )
                    }
                }
            }.launchIn(viewModelScope)
        }
    }
}