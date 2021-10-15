package com.reisdeveloper.cryptocurrencymvvm.data.model

import java.util.*

data class LiveCurrenciesResponse(
    val timestamp: Date,
    val target: String,
    val rates: List<Pair<String, String>>
)
