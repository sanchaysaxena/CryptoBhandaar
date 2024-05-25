package com.example.cryptobhandaar.di

import com.example.cryptobhandaar.common.Constants
import com.example.cryptobhandaar.data.remote.CoinPaprikaApi
import com.example.cryptobhandaar.data.repository.CoinRepositoryImpl
import com.example.cryptobhandaar.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

//here InstallIn determine how long the dependencies will live the singletonComponent signifies it lives as long as our application
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //provides-> as function provides dependencies
    //singleton-> so only one instance is there for whatever the function returns
    @Provides
    @Singleton
    fun providePaprikaApi():CoinPaprikaApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi):CoinRepository{
        return CoinRepositoryImpl(api)
    }

}