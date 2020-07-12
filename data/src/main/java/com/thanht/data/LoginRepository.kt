package com.thanht.data

class LoginRepository(val dataSource: LoginDataSource) {
    var user: LoggedInUser? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        user = null
    }

    fun login(userName: String, password: String): Result<LoggedInUser> {
        val result = dataSource.login(userName, password)
        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }
        return result
    }

    private fun setLoggedInUser(user: LoggedInUser) {
        this.user = user
    }
}