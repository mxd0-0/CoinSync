package com.example.crypto.crypto.data.networking

import com.example.crypto.core.data.networking.constructUrl
import com.example.crypto.core.data.networking.safeCall
import com.example.crypto.core.domain.util.NetworkError
import com.example.crypto.core.domain.util.Result
import com.example.crypto.core.domain.util.map
import com.example.crypto.crypto.data.mappers.toCoin
import com.example.crypto.crypto.data.networking.dto.CoinResponseDto
import com.example.crypto.crypto.domain.Coin
import com.example.crypto.crypto.domain.CoinDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(
    private val httpClient: HttpClient
) :CoinDataSource{
    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets")
            )
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }
}