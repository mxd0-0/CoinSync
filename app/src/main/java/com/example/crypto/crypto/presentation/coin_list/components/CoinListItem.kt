package com.example.crypto.crypto.presentation.coin_list.components

import android.icu.number.NumberFormatter
import android.icu.text.NumberFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.crypto.R
import com.example.crypto.crypto.domain.Coin
import com.example.crypto.crypto.presentation.models.CoinUI
import com.example.crypto.crypto.presentation.models.DisplayableNumber
import com.example.crypto.crypto.presentation.models.toCoinUi
import com.example.crypto.ui.theme.CryptoTheme
import java.util.Locale

@Composable
fun CoinListItem(
    coinUi: CoinUI,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(coinUi.iconRes),
            contentDescription = coinUi.name,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(85.dp)
        )
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                coinUi.symbol,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                coinUi.name,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Light
            )
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(text = "$ ${coinUi.priceUsd.formatted}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            PriceChange(
                coinUi.changePercent24Hr
            )

        }
    }
}

@PreviewLightDark
@Composable
private fun CoinListItemPrev() {
    CryptoTheme {
        CoinListItem(
            coinUi = previewCoinUI ,
            onClick = { /* TODO:  */},
            modifier = Modifier.background(MaterialTheme.colorScheme.surface)
        )
    }
}

val previewCoinUI = Coin(
    id = "1",
    rank = 1,
    name = "Bitcoin",
    symbol = "BTC",
    marketCapUsd =  192835467891234.75,
    priceUsd = 12345.67,
    changePercent24Hr = 0.1,
).toCoinUi()

fun Double.toDisplayableNumber(): DisplayableNumber{
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }
    return DisplayableNumber(
        this,
        formatted = formatter.format(this)
    )
}