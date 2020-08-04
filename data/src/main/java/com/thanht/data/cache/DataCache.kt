package com.thanht.data.cache

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

const val FILE_NAME = "xml_cache"
const val IS_USER_LOG_IN = "is_logged"
class DataCache @Inject constructor(context: Context) {

    private var sharedPreferences: SharedPreferences =
        context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)

    fun setIsUserLogIn(isLogged: Boolean) {
        sharedPreferences.edit().putBoolean(IS_USER_LOG_IN, isLogged).apply()
    }

    fun isUserLogIn(): Boolean = sharedPreferences.getBoolean(IS_USER_LOG_IN, false)

}