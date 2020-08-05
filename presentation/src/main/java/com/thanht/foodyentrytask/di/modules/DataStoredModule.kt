package com.thanht.foodyentrytask.di.modules

import android.app.Application
import com.thanht.data.cache.DataCache
import com.thanht.data.database.DatabaseManagerImpl
import com.thanht.domain.database.DatabaseManager
import com.thanht.foodyentrytask.di.scopes.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class DataStoredModule {

    @Provides
    @ApplicationScope
    fun provideDataCache(application: Application): DataCache = DataCache(application)

    @Provides
    @ApplicationScope
    fun provideDatabaseManager(application: Application): DatabaseManager {
        return DatabaseManagerImpl(application)
    }
}