package com.thanht.domain.login

import com.thanht.domain.model.LoggedInUser
import io.reactivex.Observable

interface LoginRepository {
    fun login(userName: String, password: String): Observable<LoggedInUser>
}