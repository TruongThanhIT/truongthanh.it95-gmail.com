package com.thanht.domain.city

import com.thanht.domain.base.BaseUseCase
import com.thanht.domain.model.CityModel
import io.reactivex.Observable
import javax.inject.Inject

class CityListUseCase @Inject constructor(private val cityRepository: CityRepository) :
    BaseUseCase<List<CityModel>>() {

    override fun buildObservable(): Observable<List<CityModel>> = cityRepository.getListCity()
}