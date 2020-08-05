package com.thanht.domain.database

import com.thanht.domain.model.CityModel
import io.reactivex.Completable
import io.reactivex.Single

interface DatabaseManager {
    fun getCityList(): Single<List<CityModel>>

    fun saveCityList(cityModels: List<CityModel>): Completable
}