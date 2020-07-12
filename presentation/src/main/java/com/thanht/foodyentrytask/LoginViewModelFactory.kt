package com.thanht.foodyentrytask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.thanht.data.LoginDataSource
import com.thanht.data.LoginRepository
import java.lang.IllegalArgumentException

class LoginViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(
                loginRepository = LoginRepository(
                    dataSource = LoginDataSource()
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}