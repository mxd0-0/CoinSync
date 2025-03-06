package com.example.crypto.crypto.presentation.coin_list

import com.example.crypto.crypto.presentation.models.CoinUI

sealed interface CoinListAction {
    data class OnCoinClick(val coinUi: CoinUI): CoinListAction
   // data object OnRefresh: CoinListAction
}