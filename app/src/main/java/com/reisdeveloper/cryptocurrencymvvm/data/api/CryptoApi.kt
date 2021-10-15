package com.reisdeveloper.cryptocurrencymvvm.data.api

import com.reisdeveloper.cryptocurrencymvvm.data.model.LiveCurrenciesResponse
import retrofit2.Response
import retrofit2.http.GET

interface CryptoApi {
    @GET("live")
    suspend fun getLiveCryptoCurrencies(): Response<LiveCurrenciesResponse>
}