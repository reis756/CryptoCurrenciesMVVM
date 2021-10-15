package com.reisdeveloper.cryptocurrencymvvm.domain.mapper

interface Mapper <VIEWMODEL, MODEL> {
    fun mapper(response: MODEL) : VIEWMODEL
}