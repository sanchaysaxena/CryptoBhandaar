package com.example.cryptobhandaar

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//this is to give dagger hilt the information about our application so it can also have access to the application context
//if that is needed for the dependencies
@HiltAndroidApp
class CoinApplication :Application()