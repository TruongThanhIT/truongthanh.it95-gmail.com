package com.thanht.foodyentrytask.di.modules

import com.thanht.data.login.LoginRepositoryImpl
import com.thanht.domain.LoginRepository
import com.thanht.domain.base.TaskSchedulers
import com.thanht.foodyentrytask.TaskSchedulersImpl
import com.thanht.foodyentrytask.di.scopes.UserScope
import dagger.Binds
import dagger.Module

@Module
abstract class UserModule {

    @Binds
    @UserScope
    abstract fun bindLoginRepository(loginDataSource: LoginRepositoryImpl): LoginRepository

    @Binds
    @UserScope
    abstract fun bindTaskSchedulers(taskSchedulersImpl: TaskSchedulersImpl): TaskSchedulers
}