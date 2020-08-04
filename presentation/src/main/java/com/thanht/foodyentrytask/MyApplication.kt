package com.thanht.foodyentrytask

import android.app.Application
import android.content.Context
import com.thanht.foodyentrytask.di.components.AppComponent
import com.thanht.foodyentrytask.di.components.DaggerAppComponent
import com.thanht.foodyentrytask.di.components.DaggerUserComponent
import com.thanht.foodyentrytask.di.components.UserComponent

class MyApplication : Application() {
    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    private val userComponent: UserComponent by lazy {
        DaggerUserComponent.builder()
            .appComponent(appComponent)
            .build()
    }
    companion object {
        fun applicationComponent(context: Context) =
            (context.applicationContext as MyApplication).appComponent

        fun userComponent(context: Context) =
            (context.applicationContext as MyApplication).userComponent
    }
}
