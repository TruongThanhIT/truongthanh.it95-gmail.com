package com.thanht.data.login

import com.thanht.data.Result
import com.thanht.domain.login.LoginRepository
import com.thanht.domain.model.LoggedInUser
import io.reactivex.Observable
import javax.inject.Inject


class LoginRepositoryImpl @Inject constructor(private val dataSource: LoginDataSource):
    LoginRepository {

    override fun login(userName: String, password: String): Observable<LoggedInUser> {
        val result = dataSource.login(userName, password)
        if (result is Result.Success) {
            return Observable.just(result.data)
        }
        return Observable.error((result as Result.Error).exception)
    }
}