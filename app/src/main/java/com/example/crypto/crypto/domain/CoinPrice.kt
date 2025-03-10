package com.example.crypto.crypto.domain

import java.time.ZonedDateTime

data class CoinPrice(
    val priceUsd : Double,
    val dateTime: ZonedDateTime,
)
