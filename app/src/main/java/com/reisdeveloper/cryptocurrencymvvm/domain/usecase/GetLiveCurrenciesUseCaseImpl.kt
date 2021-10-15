package com.reisdeveloper.cryptocurrencymvvm.domain.usecase

import com.reisdeveloper.cryptocurrencymvvm.data.repository.CryptoRepository
import com.reisdeveloper.cryptocurrencymvvm.domain.mapper.LiveCurrencyMapper
import com.reisdeveloper.cryptocurrencymvvm.domain.model.LiveCurrencies

class GetLiveCurrenciesUseCaseImpl(
    private val cryptoRepository: CryptoRepository,
    private val liveCurrencyMapper: LiveCurrencyMapper
) : GetLiveCurrenciesUseCase {

    override suspend fun invoke(): LiveCurrencies? = try {
        liveCurrencyMapper.mapper(cryptoRepository.getLiveCryptoCurrencies())
    } catch (ex: Exception) {
        ex.printStackTrace()
        null
    }
}

interface GetLiveCurrenciesUseCase {
    suspend operator fun invoke(): LiveCurrencies?
}