package com.thanht.data.database

import androidx.room.*
import com.thanht.data.database.CityEntity
import com.thanht.domain.model.CityModel
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface CityDao {
    @Query("SELECT * FROM city")
    fun getAll(): Single<List<CityEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(cityEntity: List<CityEntity>): Completable
}