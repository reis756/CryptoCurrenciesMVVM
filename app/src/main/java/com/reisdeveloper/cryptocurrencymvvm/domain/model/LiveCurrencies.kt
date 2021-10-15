package com.reisdeveloper.cryptocurrencymvvm.domain.model

import java.util.*

data class LiveCurrencies(
    val timestamp: Date,
    val target: String,
    val rates: List<Pair<String, String>>
)