package com.thanht.foodyentrytask.util

import com.thanht.domain.model.CityModel
import com.thanht.foodyentrytask.home.list.CityInfo

fun CityModel.toCityInfo(): CityInfo = CityInfo(id, name)

fun List<CityModel>.toCityInfoList(): List<CityInfo> = map { it.toCityInfo() }