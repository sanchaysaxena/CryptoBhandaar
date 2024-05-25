package com.example.cryptobhandaar.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.cryptobhandaar.domain.model.Coin
import com.example.cryptobhandaar.domain.use_case.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase
):ViewModel(){

    //here we have made 2 state 1 private and 1 public as we don't want to be able to modify the content of _state in our composable
    private val _state= mutableStateOf(CoinListState())
    val state:State<CoinListState> = _state




}