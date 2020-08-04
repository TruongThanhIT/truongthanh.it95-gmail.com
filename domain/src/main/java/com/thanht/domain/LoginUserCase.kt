package com.thanht.domain

import com.thanht.domain.base.BaseUseCase
import com.thanht.domain.model.LoggedInUser
import io.reactivex.Observable
import javax.inject.Inject

class LoginUserCase @Inject constructor(private val loginRepository: LoginRepository): BaseUseCase<LoggedInUser>() {
    private var name = ""
    private var pass = ""

    fun setParams(userName: String, password: String) {
        name = userName
        pass = password
    }

    override fun buildObservable(): Observable<LoggedInUser> = loginRepository.login(name, pass)
}