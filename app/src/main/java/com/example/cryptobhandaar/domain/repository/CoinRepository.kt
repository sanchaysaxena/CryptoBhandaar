package com.example.cryptobhandaar.domain.repository

import com.example.cryptobhandaar.data.remote.dto.CoinDetailDto
import com.example.cryptobhandaar.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins():List<CoinDto>

    suspend fun getCoinById(coinId:String):CoinDetailDto
}