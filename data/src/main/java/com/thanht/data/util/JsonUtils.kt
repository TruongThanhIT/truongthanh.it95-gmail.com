package com.thanht.data.util

import android.content.Context
import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

object JsonUtils {
    private var gSon: Gson = GsonBuilder().disableHtmlEscaping().create()

    fun <T> parse(json: String?, tClass: Class<T>): T? {
        if (!TextUtils.isEmpty(json)) {
            try {
                return getGson()
                    .fromJson(json, tClass)
            } catch (ignore: Exception) {
            }
        }
        return null
    }

    @Synchronized
    fun getGson(): Gson = gSon

    fun getJSONData(context: Context, textFileName: String): String {
        var strJSON = ""
        val builder = StringBuilder()
        val json: InputStream
        try {
            json = context.assets.open(textFileName)
            val bufferedReader = BufferedReader(InputStreamReader(json, "UTF-8"))
            while ((bufferedReader.readLine()?.also { strJSON = it }) != null) {
                builder.append(strJSON)
            }
            bufferedReader.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return builder.toString()
    }
}