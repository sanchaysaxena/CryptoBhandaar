package com.example.cryptobhandaar.domain.use_case.get_coins

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.cryptobhandaar.common.Resource
import com.example.cryptobhandaar.data.remote.dto.toCoin
import com.example.cryptobhandaar.domain.model.Coin
import com.example.cryptobhandaar.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository:CoinRepository
) {
    //here invoke allows instances of a class to be called as functions
    //which we have called in view models
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins=repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        }
        catch (e:HttpException){
            emit(Resource.Error(e.localizedMessage?:"An Unexpected Error occurred"))
        }
        catch (e: IOException){
            emit(Resource.Error("Couldn't reach server check your internet connection"))
        }
    }
}