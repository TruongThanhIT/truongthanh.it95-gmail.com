package com.thanht.domain.city

import com.thanht.domain.base.BaseUseCase
import com.thanht.domain.database.DatabaseManager
import com.thanht.domain.model.CityModel
import io.reactivex.Observable
import javax.inject.Inject

class SaveCityListUseCase @Inject constructor(private val databaseManager: DatabaseManager) :
    BaseUseCase<Unit>() {
    private lateinit var cityList: List<CityModel>

    fun setParam(data: List<CityModel>) {
        cityList = data
    }

    override fun buildObservable(): Observable<Unit> =
        databaseManager.saveCityList(cityList).toObservable()
}