package com.example.crypto.crypto.presentation.coin_list

import com.example.crypto.crypto.presentation.models.CoinUI

data class CoinListState (
    val  isLoading: Boolean= false,
    val coinList : List<CoinUI> = emptyList(),
    val selectedCoin: CoinUI? = null,
)