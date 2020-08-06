package com.thanht.data.login

import com.thanht.data.Result
import com.thanht.domain.model.LoggedInUser
import java.util.*

class LoginDataSource {
    fun login(userName: String, password: String): Result<LoggedInUser> {
        return if (userName == "thanh" && password == "123") {
            val fakeUser = LoggedInUser(
                UUID.randomUUID().toString(), "Thanh Mia"
            )
            Result.Success(fakeUser)
        } else {
            Result.Error(IllegalArgumentException("Invalid info"))
        }
    }
}