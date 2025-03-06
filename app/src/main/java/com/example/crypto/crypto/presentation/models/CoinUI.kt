package com.example.crypto.crypto.presentation.models

import androidx.annotation.DrawableRes
import com.example.crypto.crypto.domain.Coin
import com.example.crypto.crypto.presentation.coin_list.components.toDisplayableNumber
import com.example.crypto.core.presentation.util.getDrawableIdForCoin

data class CoinUI(
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    val marketCapUsd: DisplayableNumber,
    val priceUsd: DisplayableNumber,
    val changePercent24Hr: DisplayableNumber,
    @DrawableRes val iconRes: Int,
)

data class DisplayableNumber(
    val value: Double,
    val formatted: String,
)
fun Coin.toCoinUi(): CoinUI{
    return CoinUI(
        id = id,
        name= name,
        symbol = symbol,
        rank = rank,
        marketCapUsd = marketCapUsd.toDisplayableNumber(),
        priceUsd = priceUsd.toDisplayableNumber(),
        changePercent24Hr = changePercent24Hr.toDisplayableNumber(),
        iconRes = getDrawableIdForCoin(symbol)
    )
}