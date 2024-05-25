package com.example.cryptobhandaar.presentation.coin_list

import com.example.cryptobhandaar.domain.model.Coin

data class CoinListState(
    val isLoading:Boolean=false,
    val coins:List<Coin> = emptyList(),
    val error:String=""
)
