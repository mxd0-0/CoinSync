package com.example.crypto.crypto.presentation.coin_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crypto.core.domain.util.onError
import com.example.crypto.core.domain.util.onSuccess
import com.example.crypto.crypto.domain.CoinDataSource
import com.example.crypto.crypto.presentation.models.toCoinUi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CoinListViewModel(
    private val coinDataSource: CoinDataSource,
) : ViewModel() {
    private val _state = MutableStateFlow(CoinListState())

    val state = _state.onStart { loadCoins() }.stateIn(
        viewModelScope, SharingStarted
            .WhileSubscribed(5000L),
        CoinListState()
    )

    fun onAction(action: CoinListAction) {
        when (action) {
            is CoinListAction.OnCoinClick -> {
            }
        }
    }

    private val _events = Channel<CoinListEvent>()
    val event = _events.receiveAsFlow()
    private fun loadCoins() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }
            coinDataSource.getCoins().onSuccess { coins ->
                _state.update {
                    it.copy(isLoading = false, coins = coins.map { it.toCoinUi() })
                }
            }.onError { error ->
                _state.update {
                    it.copy(
                        isLoading = false
                    )
                }
                _events.send(CoinListEvent.Error(error))
            }
        }
    }
}