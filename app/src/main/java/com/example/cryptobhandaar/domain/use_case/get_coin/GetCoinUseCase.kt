package com.example.cryptobhandaar.domain.use_case.get_coin

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.cryptobhandaar.common.Resource
import com.example.cryptobhandaar.data.remote.dto.toCoin
import com.example.cryptobhandaar.data.remote.dto.toCoinDetail
import com.example.cryptobhandaar.domain.model.Coin
import com.example.cryptobhandaar.domain.model.CoinDetail
import com.example.cryptobhandaar.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository:CoinRepository
) {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin=repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        }
        catch (e:HttpException){
            emit(Resource.Error(e.localizedMessage?:"An Unexpected Error occurred"))
        }
        catch (e: IOException){
            emit(Resource.Error("Couldn't reach server check your internet connection"))
        }
    }
}