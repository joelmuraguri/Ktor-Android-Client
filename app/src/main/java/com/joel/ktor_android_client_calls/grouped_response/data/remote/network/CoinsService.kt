package com.joel.ktor_android_client_calls.grouped_response.data.remote.network

import com.joel.ktor_android_client_calls.common.HttpRoutes
import com.joel.ktor_android_client_calls.common.KtorDemoException
import com.joel.ktor_android_client_calls.grouped_response.data.dto.CoinDetailsDTO
import com.joel.ktor_android_client_calls.grouped_response.data.dto.CoinsDTO
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import javax.inject.Inject

class CoinsService @Inject constructor(
    private val client: HttpClient
){

    suspend fun getCoins(): List<CoinsDTO> {
        return try {
            client.get{
                url(HttpRoutes.GET_COINS)
            }
        } catch (e : ClientRequestException){
            throw KtorDemoException(e.response.status.description)
        } catch ( e : ServerResponseException){
            throw KtorDemoException(e.response.status.description)
        } catch ( e : RedirectResponseException){
            throw KtorDemoException(e.response.status.description)
        } catch (e : Exception){
            throw KtorDemoException(e.localizedMessage ?: "Something went wrong")
        }
    }

    suspend fun getCoinDetails(coinId: String): CoinDetailsDTO {
        return try {
            client.get{
                url("${HttpRoutes.GET_COIN_DETAILS}/$coinId")
            }
        } catch (e : ClientRequestException){
            throw KtorDemoException(e.response.status.description)
        } catch ( e : ServerResponseException){
            throw KtorDemoException(e.response.status.description)
        } catch ( e : RedirectResponseException){
            throw KtorDemoException(e.response.status.description)
        } catch (e : Exception){
            throw KtorDemoException(e.localizedMessage ?: "Something went wrong")
        }
    }
}