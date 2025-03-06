package com.example.crypto.di

import com.example.crypto.core.data.networking.HttpClientFactory
import io.ktor.client.engine.cio.CIO
import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf
import com.example.crypto.crypto.data.networking.RemoteCoinDataSource
import com.example.crypto.crypto.domain.CoinDataSource
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.bind
import com.example.crypto.crypto.presentation.coin_list.CoinListViewModel


val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()
    viewModelOf(::CoinListViewModel)
}