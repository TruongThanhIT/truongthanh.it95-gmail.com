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
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class CityListViewModel @Inject constructor(
    private val cityListUseCase: CityListUseCase,
    private val saveCityListUseCase: SaveCityListUseCase,
    private val taskSchedulers: TaskSchedulers
) : ViewModel() {

    private val _cityListResult = MutableLiveData<CityListResult>()
    val cityListResult: LiveData<CityListResult> = _cityListResult

    override fun onCleared() {
        cityListUseCase.unsubscribe()
        saveCityListUseCase.unsubscribe()
        super.onCleared()
    }

    fun getListCity() {
        cityListUseCase.apply {
            unsubscribe()
            execute(object : DisposableObserver<List<CityModel>>() {
                override fun onComplete() {
                }

                override fun onNext(result: List<CityModel>) {
                    _cityListResult.value = CityListResult(success = result.toCityInfoList())
                    saveCityListToDB(result)
                }

                override fun onError(e: Throwable) {
                    _cityListResult.value = CityListResult(error = e.message)
                }

            }, taskSchedulers)
        }
    }

    private fun saveCityListToDB(result: List<CityModel>) {
        saveCityListUseCase.apply {
            unsubscribe()
            setParam(result)
            execute(object : DisposableObserver<Unit>() {
                override fun onComplete() {
                }

                override fun onNext(t: Unit) {
                }

                override fun onError(e: Throwable) {
                }

            }, taskSchedulers)
        }
    }
}