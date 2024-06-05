package com.example.cryptobhandaar.presentation.coin_detail

import com.example.cryptobhandaar.domain.model.Coin
import com.example.cryptobhandaar.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading:Boolean=false,
    val coin:CoinDetail? = null,
    val error:String=""
)
