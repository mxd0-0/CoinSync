package com.example.crypto.crypto.presentation.coin_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crypto.core.domain.util.onError
import com.example.crypto.core.domain.util.onSuccess
import com.example.crypto.crypto.domain.CoinDataSource
import com.example.crypto.crypto.presentation.models.toCoinUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CoinListViewModel(
    private val coinDataSource: CoinDataSource,
) : ViewModel() {
    private val _state = MutableStateFlow(CoinListState())
    val state = _state
        .onStart { loadCoins() }
        .stateIn(
            viewModelScope,
           SharingStarted.WhileSubscribed(5000L),
            CoinListState()
        )



    private fun loadCoins() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }

            coinDataSource
                .getCoins()
                .onSuccess { coins ->
                    _state.update {
                        it.copy(isLoading = false, coinList = coins.map {
                            it.toCoinUi()
                        })
                    }
                }
                .onError {
                    _state.update {
                        it.copy(
                            isLoading = false
                        )
                    }
                }
        }

    }
}