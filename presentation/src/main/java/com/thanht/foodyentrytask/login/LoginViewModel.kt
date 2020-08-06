package com.thanht.foodyentrytask.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thanht.data.cache.DataCache
import com.thanht.domain.login.LoginUserCase
import com.thanht.domain.base.TaskSchedulers
import com.thanht.domain.model.LoggedInUser
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginUserCase: LoginUserCase,
    private val taskSchedulers: TaskSchedulers,
    private val dataCache: DataCache
) : ViewModel() {

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    override fun onCleared() {
        loginUserCase.unsubscribe()
        super.onCleared()
    }

    fun login(userName: String, password: String) {
        loginUserCase.apply {
            unsubscribe()
            setParams(userName, password)
            execute(object : DisposableObserver<LoggedInUser>() {
                override fun onComplete() {
                }

                override fun onNext(result: LoggedInUser) {
                    dataCache.setIsUserLogIn(true)
                    _loginResult.value = LoginResult(success = LoggedInUserView(result.userName))
                }

                override fun onError(e: Throwable) {
                    _loginResult.value = LoginResult(error = e.message)
                }

            }, taskSchedulers)
        }
    }
}