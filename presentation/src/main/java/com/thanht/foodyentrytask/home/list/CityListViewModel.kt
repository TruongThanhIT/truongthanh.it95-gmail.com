package com.thanht.foodyentrytask.home.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thanht.domain.base.TaskSchedulers
import com.thanht.domain.city.CityListUseCase
import com.thanht.foodyentrytask.util.toCityInfoList
import javax.inject.Inject

class CityListViewModel @Inject constructor(
    private val cityListUseCase: CityListUseCase,
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
                    {
                        result ->
                        _cityListResult.value = CityListResult(success = result.toCityInfoList())
                    },
                    {
                        _cityListResult.value = CityListResult(error = it.message)
                    }
                )
        }
    }
}