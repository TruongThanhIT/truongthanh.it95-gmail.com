package com.thanht.foodyentrytask.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thanht.data.cache.DataCache
import javax.inject.Inject

class SplashViewModel @Inject constructor(private val dataCache: DataCache) : ViewModel() {
    private val _splashState = MutableLiveData<SplashState>()
    val splashState: LiveData<SplashState> = _splashState

    fun userLogin() {
        _splashState.value = if (dataCache.isUserLogIn()) SplashState.HomeActivity
        else SplashState.LoginActivity
    }
}

sealed class SplashState {
    object LoginActivity : SplashState()
    object HomeActivity : SplashState()
}