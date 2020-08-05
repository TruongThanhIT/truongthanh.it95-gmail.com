package com.thanht.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city")
class CityEntity (
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "city_name") val cityName: String
)