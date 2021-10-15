package com.reisdeveloper.cryptocurrencymvvm.data.repository

import com.reisdeveloper.cryptocurrencymvvm.data.Output
import com.reisdeveloper.cryptocurrencymvvm.data.api.CryptoApi
import com.reisdeveloper.cryptocurrencymvvm.data.model.LiveCurrenciesResponse
import com.reisdeveloper.cryptocurrencymvvm.data.parseResponse

class CryptoRepositoryImpl(
    private val service: CryptoApi
) : CryptoRepository {

    override suspend fun getLiveCryptoCurrencies(): LiveCurrenciesResponse {

        return when (val result = service.getLiveCryptoCurrencies().parseResponse()) {
            is Output.Success -> result.value
            is Output.Failure -> throw GetLiveCurrenciesException()
        }
    }
}

interface CryptoRepository {
    suspend fun getLiveCryptoCurrencies(): LiveCurrenciesResponse
}

class GetLiveCurrenciesException : Exception()