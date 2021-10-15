package com.reisdeveloper.cryptocurrencymvvm.domain.mapper

import com.reisdeveloper.cryptocurrencymvvm.data.model.LiveCurrenciesResponse
import com.reisdeveloper.cryptocurrencymvvm.domain.model.LiveCurrencies

interface LiveCurrencyMapper : Mapper<LiveCurrencies, LiveCurrenciesResponse>

class LiveCurrencyMapperImpl : LiveCurrencyMapper {
    override fun mapper(response: LiveCurrenciesResponse) = LiveCurrencies(
        timestamp = response.timestamp,
        target = response.target,
        rates = response.rates
    )
}