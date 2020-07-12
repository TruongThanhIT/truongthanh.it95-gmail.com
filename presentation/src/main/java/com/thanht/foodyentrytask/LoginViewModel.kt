package com.thanht.foodyentrytask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thanht.data.LoginRepository
import com.thanht.data.Result

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {
    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(userName: String, password: String) {
        val result = loginRepository.login(userName, password)
        if (result is Result.Success) {
            _loginResult.value =
                LoginResult(success = LoggedInUserView(result.data.userName))
        } else {
            _loginResult.value = LoginResult(error = R.string.login_failed)
        }
    }
}