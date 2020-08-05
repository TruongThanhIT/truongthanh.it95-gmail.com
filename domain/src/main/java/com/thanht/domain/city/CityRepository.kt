package com.thanht.domain.city

import com.thanht.domain.model.CityModel
import io.reactivex.Observable

interface CityRepository {
    fun getListCity(): Observable<List<CityModel>>
}