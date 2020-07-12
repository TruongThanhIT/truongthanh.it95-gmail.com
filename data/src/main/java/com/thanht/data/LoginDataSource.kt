package com.thanht.data

import java.io.IOException
import java.util.UUID

class LoginDataSource {
    fun login(userName: String, password: String): Result<LoggedInUser> {
        return if (userName == "thanh" && password == "123") {
            val fakeUser = LoggedInUser(UUID.randomUUID().toString(), "Thanh Mia")
            Result.Success(fakeUser)
        } else {
            Result.Error(IOException("Login Failed"))
        }
    }
}