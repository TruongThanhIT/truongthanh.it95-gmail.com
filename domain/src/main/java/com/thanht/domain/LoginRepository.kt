package com.thanht.domain

import com.thanht.domain.model.LoggedInUser
import io.reactivex.Observable

interface LoginRepository {
    fun login(userName: String, password: String): Observable<LoggedInUser>
}