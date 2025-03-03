package com.example.crypto.crypto.data.mappers

import com.example.crypto.crypto.data.networking.dto.CoinDto
import com.example.crypto.crypto.domain.Coin

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr
    )

}