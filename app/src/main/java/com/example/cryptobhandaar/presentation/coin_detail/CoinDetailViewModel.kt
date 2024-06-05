package com.example.cryptobhandaar.presentation.coin_detail

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptobhandaar.common.Constants
import com.example.cryptobhandaar.common.Resource
import com.example.cryptobhandaar.domain.use_case.get_coin.GetCoinUseCase
import com.example.cryptobhandaar.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

//SavedStateHandle is a bundle that contains information of saved state that we can use to restore our app
//it also have navigation parameters so we can pas data in SavedStateHandle
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle:SavedStateHandle
):ViewModel(){

    //here we have made 2 state 1 private and 1 public as we don't want to be able to modify the content of _state in our composable
    private val _state= mutableStateOf(CoinDetailState())
    val state:State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let {coinId->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId:String){
        getCoinUseCase(coinId).onEach {result->
            when(result){
                is Resource.Success->{
                    _state.value= CoinDetailState(coin = result.data)
                }
                is Resource.Error->{
                    _state.value=CoinDetailState(error = result.message?:"An unexpected error occurred")
                }
                is Resource.Loading->{
                    _state.value=CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }


}