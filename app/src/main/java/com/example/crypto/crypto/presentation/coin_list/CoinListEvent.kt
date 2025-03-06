package com.example.crypto.crypto.presentation.coin_list

import com.example.crypto.core.domain.util.NetworkError

sealed interface CoinListEvent {
    data class  Error(val error: NetworkError) : CoinListEvent
}