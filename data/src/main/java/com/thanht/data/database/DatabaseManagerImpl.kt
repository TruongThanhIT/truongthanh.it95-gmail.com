package com.thanht.data.database

import android.content.Context
import androidx.room.Room
import com.thanht.data.util.toCityEntities
import com.thanht.data.util.toCityModels
import com.thanht.domain.database.DatabaseManager
import com.thanht.domain.model.CityModel
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class DatabaseManagerImpl @Inject constructor(context: Context) : DatabaseManager {
    private val database: AppDatabase = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        "weather-map-db"
    ).build()

    private val cityDao = database.cityDao()

    override fun getCityList(): Single<List<CityModel>> {
        return cityDao.getAll().map { it.toCityModels() }
    }

    override fun saveCityList(cityModels: List<CityModel>): Completable {
        return cityDao.insertAll(cityModels.toCityEntities())
    }
}