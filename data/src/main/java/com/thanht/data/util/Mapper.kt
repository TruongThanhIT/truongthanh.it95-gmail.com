package com.thanht.data.util

import com.thanht.data.city.CityResponse
import com.thanht.domain.model.CityModel

fun CityResponse.toCityModel(): CityModel = CityModel(id, name)

fun List<CityResponse>.toCityModelList(): List<CityModel> = map { it.toCityModel() }