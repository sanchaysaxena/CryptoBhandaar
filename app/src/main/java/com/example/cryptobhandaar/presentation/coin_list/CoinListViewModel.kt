package com.example.cryptobhandaar.presentation.coin_list

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptobhandaar.common.Resource
import com.example.cryptobhandaar.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
):ViewModel(){

    //here we have made 2 state 1 private and 1 public as we don't want to be able to modify the content of _state in our composable
    private val _state= mutableStateOf(CoinListState())
    val state:State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins(){
        getCoinsUseCase().onEach {result->
            when(result){
                is Resource.Success->{
                    _state.value= CoinListState(coins = result.data?: emptyList())
                }
                is Resource.Error->{
                    _state.value=CoinListState(error = result.message?:"An unexpected error occurred")
                }
                is Resource.Loading->{
                    _state.value=CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }


}