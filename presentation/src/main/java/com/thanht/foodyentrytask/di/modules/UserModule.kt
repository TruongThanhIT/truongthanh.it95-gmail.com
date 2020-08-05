package com.thanht.foodyentrytask.di.modules

import com.thanht.data.city.CityDataSource
import com.thanht.data.city.CityRepositoryImpl
import com.thanht.data.login.LoginRepositoryImpl
import com.thanht.domain.login.LoginRepository
import com.thanht.domain.base.TaskSchedulers
import com.thanht.domain.city.CityRepository
import com.thanht.foodyentrytask.TaskSchedulersImpl
import com.thanht.foodyentrytask.di.scopes.UserScope
import dagger.Binds
import dagger.Module

@Module
abstract class UserModule {

    // Task
    @Binds
    @UserScope
    abstract fun bindTaskSchedulers(taskSchedulersImpl: TaskSchedulersImpl): TaskSchedulers

    // repository
    @Binds
    @UserScope
    abstract fun bindLoginRepository(loginRepositoryImpl: LoginRepositoryImpl): LoginRepository

    @Binds
    @UserScope
    abstract fun bindCityRepository(cityRepositoryImpl: CityRepositoryImpl): CityRepository
}