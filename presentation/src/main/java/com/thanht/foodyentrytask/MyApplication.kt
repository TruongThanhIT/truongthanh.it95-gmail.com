package com.thanht.foodyentrytask

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.facebook.stetho.Stetho
import com.thanht.data.database.AppDatabase
import com.thanht.foodyentrytask.di.components.AppComponent
import com.thanht.foodyentrytask.di.components.DaggerAppComponent
import com.thanht.foodyentrytask.di.components.DaggerUserComponent
import com.thanht.foodyentrytask.di.components.UserComponent

class MyApplication : Application() {

    val userComponent: UserComponent by lazy {
        DaggerUserComponent.builder()
            .appComponent(appComponent)
            .build()
    }

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this);
    }
}
