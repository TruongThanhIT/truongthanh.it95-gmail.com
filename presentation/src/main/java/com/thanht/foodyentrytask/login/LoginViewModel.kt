package com.thanht.foodyentrytask.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thanht.data.cache.DataCache
import com.thanht.domain.LoginUserCase
import com.thanht.domain.base.TaskSchedulers
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginUserCase: LoginUserCase,
    private val taskSchedulers: TaskSchedulers,
    private val dataCache: DataCache
) : ViewModel() {

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(userName: String, password: String) {
        loginUserCase.apply {
            unsubscribe()
            setParams(userName, password)
            completeObservable(taskSchedulers)
                .observeOn(taskSchedulers.getMainThread())
                .subscribe(
                    { result ->
                        dataCache.setIsUserLogIn(true)
                        _loginResult.value =
                            LoginResult(success = LoggedInUserView(result.userName))
                    },

                    { throwable ->
                        _loginResult.value = LoginResult(error = throwable.message)
                    }
                )
        }
    }
}