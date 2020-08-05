package com.thanht.data.city

import android.content.Context
import com.google.gson.reflect.TypeToken
import com.thanht.data.Result
import com.thanht.data.util.JsonUtils
import java.io.IOException
import javax.inject.Inject

class CityDataSource @Inject constructor(val context: Context) {

    fun getCityList(): Result<Collection<CityResponse>> {
        val jsonString = JsonUtils.getJSONData(context, "city.json")
        val collectionType = object : TypeToken<Collection<CityResponse?>?>() {}.type
        val cityResponses: Collection<CityResponse>? = JsonUtils.getGson().fromJson(jsonString, collectionType)
        cityResponses?.let {
            return Result.Success(it)
        }
        return Result.Error(IOException("Error get list"))
    }
}