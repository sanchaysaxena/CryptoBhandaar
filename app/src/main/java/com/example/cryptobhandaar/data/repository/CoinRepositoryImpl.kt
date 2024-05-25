package com.example.cryptobhandaar.data.repository

import com.example.cryptobhandaar.data.remote.CoinPaprikaApi
import com.example.cryptobhandaar.data.remote.dto.CoinDetailDto
import com.example.cryptobhandaar.data.remote.dto.CoinDto
import com.example.cryptobhandaar.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
):CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}