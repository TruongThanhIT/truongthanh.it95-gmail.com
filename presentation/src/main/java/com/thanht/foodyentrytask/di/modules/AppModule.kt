package com.thanht.foodyentrytask.di.modules

import com.thanht.data.login.LoginDataSource
import com.thanht.foodyentrytask.di.scopes.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
object AppModule {

    @Provides
    @ApplicationScope
    fun provideLoginDataSource(): LoginDataSource {
        return LoginDataSource()
    }
}