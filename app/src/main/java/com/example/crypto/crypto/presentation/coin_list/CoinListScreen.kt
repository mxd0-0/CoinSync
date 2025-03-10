package com.example.crypto.crypto.presentation.coin_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.crypto.crypto.presentation.coin_list.components.CoinListItem
import com.example.crypto.crypto.presentation.coin_list.components.previewCoinUI
import com.example.crypto.ui.theme.CryptoTheme

@Composable
fun CoinListScreen(
    state: CoinListState,
    onAction : (CoinListAction) -> Unit = {},
    modifier: Modifier = Modifier,
) {
    if (state.isLoading) {
        Box(
            modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.coins) { coinUi ->
                CoinListItem(
                    coinUi = coinUi, onClick = {/*TODO*/ }, modifier = Modifier.fillMaxWidth()
                )
                HorizontalDivider()
            }
        }
    }
}


@PreviewLightDark
@Composable
private fun CoinScreenPrev() {
    CryptoTheme {
        CoinListScreen(
            state = CoinListState(
                coins = (1..100).map {
                    previewCoinUI
                },

                ),
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        )
    }
}
