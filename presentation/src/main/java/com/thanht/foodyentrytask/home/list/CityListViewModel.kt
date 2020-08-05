package com.thanht.foodyentrytask.home.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thanht.domain.base.TaskSchedulers
import com.thanht.domain.city.CityListUseCase
import com.thanht.domain.city.SaveCityListUseCase
import com.thanht.domain.database.DatabaseManager
import com.thanht.domain.model.CityModel
import com.thanht.foodyentrytask.util.toCityInfoList
import javax.inject.Inject

class CityListViewModel @Inject constructor(
    private val cityListUseCase: CityListUseCase,
    private val saveCityListUseCase: SaveCityListUseCase,
    private val taskSchedulers: TaskSchedulers
) : ViewModel() {

    private val _cityListResult = MutableLiveData<CityListResult>()
    val cityListResult: LiveData<CityListResult> = _cityListResult

    fun getListCity() {
        cityListUseCase.apply {
            unsubscribe()
            completeObservable(taskSchedulers)
                .observeOn(taskSchedulers.getMainThread())
                .subscribe(
                    { result ->
                        _cityListResult.value = CityListResult(success = result.toCityInfoList())
                        saveCityListToDB(result)
                    },
                    {
                        _cityListResult.value = CityListResult(error = it.message)
                    }
                )
        }
    }

    private fun saveCityListToDB(result: List<CityModel>) {
        saveCityListUseCase.apply {
            unsubscribe()
            setParam(result)
            completeObservable(taskSchedulers)
                .observeOn(taskSchedulers.getMainThread())
                .subscribe()
        }
    }
}