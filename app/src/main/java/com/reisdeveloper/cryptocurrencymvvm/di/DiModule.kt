package com.reisdeveloper.cryptocurrencymvvm.di

import com.reisdeveloper.cryptocurrencymvvm.data.api.CryptoApi
import com.reisdeveloper.cryptocurrencymvvm.data.repository.CryptoRepository
import com.reisdeveloper.cryptocurrencymvvm.data.repository.CryptoRepositoryImpl
import com.reisdeveloper.cryptocurrencymvvm.domain.mapper.LiveCurrencyMapper
import com.reisdeveloper.cryptocurrencymvvm.domain.mapper.LiveCurrencyMapperImpl
import com.reisdeveloper.cryptocurrencymvvm.domain.usecase.GetLiveCurrenciesUseCase
import com.reisdeveloper.cryptocurrencymvvm.domain.usecase.GetLiveCurrenciesUseCaseImpl
import com.reisdeveloper.cryptocurrencymvvm.network.Service
import com.reisdeveloper.cryptocurrencymvvm.presenter.ui.LiveCurrenciesViewModel
import org.koin.dsl.module

val cryptoDataModule = module {
    single { Service().createService(CryptoApi::class.java) }
    single { LiveCurrenciesViewModel(get()) }
    single<GetLiveCurrenciesUseCase> { GetLiveCurrenciesUseCaseImpl(get(), get()) }
    single<LiveCurrencyMapper> { LiveCurrencyMapperImpl() }
    single<CryptoRepository> { CryptoRepositoryImpl(get()) }
}