package com.example.crypto.crypto.domain

import com.example.crypto.core.domain.util.NetworkError
import com.example.crypto.core.domain.util.Result

interface CoinDataSource {
    suspend fun getCoins(): Result< List<Coin> , NetworkError>
}