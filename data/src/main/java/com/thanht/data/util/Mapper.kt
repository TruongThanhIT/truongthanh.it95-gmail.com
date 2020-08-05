package com.thanht.data.util

import com.thanht.data.city.CityResponse
import com.thanht.data.database.CityEntity
import com.thanht.domain.model.CityModel

fun CityResponse.toCityModel(): CityModel = CityModel(id, name)

fun List<CityResponse>.toCityModelList(): List<CityModel> = map { it.toCityModel() }

fun CityEntity.toCityModel(): CityModel = CityModel(id.toLong(), cityName)

fun List<CityEntity>.toCityModels(): List<CityModel> = map { it.toCityModel() }

fun CityModel.toCityEntity(): CityEntity = CityEntity(id.toInt(), name)

fun List<CityModel>.toCityEntities(): List<CityEntity> = map { it.toCityEntity() }
