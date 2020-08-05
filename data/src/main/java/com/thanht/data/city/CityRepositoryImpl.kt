package com.thanht.data.city

import com.thanht.data.Result
import com.thanht.data.util.toCityModelList
import com.thanht.domain.city.CityRepository
import com.thanht.domain.model.CityModel
import io.reactivex.Observable
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(private val dataSource: CityDataSource) :
    CityRepository {
    override fun getListCity(): Observable<List<CityModel>> {
        val result = dataSource.getCityList()
        if (result is Result.Success) {
            return Observable.just(result.data.toList().toCityModelList())
        }
        return Observable.error((result as Result.Error).exception)
    }
}