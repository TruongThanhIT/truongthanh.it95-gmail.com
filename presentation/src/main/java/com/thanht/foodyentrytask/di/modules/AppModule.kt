package com.thanht.foodyentrytask.di.modules

import android.app.Application
import android.content.Context
import com.thanht.data.city.CityDataSource
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

    @Provides
    @ApplicationScope
    fun provideCityDataSource(application: Application): CityDataSource {
        return CityDataSource(application)
    }
}