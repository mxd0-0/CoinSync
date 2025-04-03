@file:OptIn(ExperimentalMaterial3AdaptiveApi::class)

package com.example.crypto.core.navigation

import android.widget.Toast
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.NavigableListDetailPaneScaffold
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.crypto.core.presentation.util.ObserveAsEvents
import com.example.crypto.core.presentation.util.toString
import com.example.crypto.crypto.presentation.coin_detail.CoinDetailScreen
import com.example.crypto.crypto.presentation.coin_list.CoinListAction
import com.example.crypto.crypto.presentation.coin_list.CoinListEvent
import com.example.crypto.crypto.presentation.coin_list.CoinListScreen
import com.example.crypto.crypto.presentation.coin_list.CoinListViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AdaptiveCoinListDetailPan(
    viewModel: CoinListViewModel = koinViewModel(),
    modifier: Modifier = Modifier,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    val context = LocalContext.current
    ObserveAsEvents(
        events = viewModel.event
    ) { event ->
        when (event) {
            is CoinListEvent.Error -> {
                Toast.makeText(
                    context, event.error.toString(context), Toast.LENGTH_LONG
                ).show()
            }
        }

    }


    val navigator = rememberListDetailPaneScaffoldNavigator<Any>()
    NavigableListDetailPaneScaffold(
        navigator = navigator,
        listPane = {
            AnimatedPane {
                CoinListScreen(
                    state = state,
                    onAction = { action ->
                        viewModel.onAction(action)
                        when (action) {
                            is CoinListAction.OnCoinClick -> {
                                navigator.navigateTo(pane = ListDetailPaneScaffoldRole.Detail)
                            }
                        }
                    }
                )
            }
        },
        detailPane = {
            AnimatedPane {
                CoinDetailScreen(
                    state
                )
            }
        },
        modifier = modifier
    )
}