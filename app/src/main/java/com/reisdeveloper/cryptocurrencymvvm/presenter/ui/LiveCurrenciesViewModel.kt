package com.reisdeveloper.cryptocurrencymvvm.presenter.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reisdeveloper.cryptocurrencymvvm.domain.model.LiveCurrencies
import com.reisdeveloper.cryptocurrencymvvm.domain.usecase.GetLiveCurrenciesUseCase
import kotlinx.coroutines.launch

class LiveCurrenciesViewModel(
    private val getLiveCurrenciesUseCase: GetLiveCurrenciesUseCase
) : ViewModel() {

    private val _currencies = MutableLiveData<LiveCurrencies>()
    val currencies = _currencies as LiveData<LiveCurrencies>
    val loading = MutableLiveData<Boolean>(false)

    fun getLiveCurrencies() {
        viewModelScope.launch {
            loading.value = true
            _currencies.value = getLiveCurrenciesUseCase()
            loading.value = false
        }
    }
}