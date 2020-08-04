package com.thanht.foodyentrytask.di.components

import com.thanht.foodyentrytask.login.LoginActivity
import com.thanht.foodyentrytask.di.modules.UserModule
import com.thanht.foodyentrytask.di.scopes.UserScope
import com.thanht.foodyentrytask.splash.SplashActivity
import dagger.Component

@UserScope
@Component(
    dependencies = [AppComponent::class],
    modules = [UserModule::class]
)
interface UserComponent {

    fun inject(activity: LoginActivity)

    fun inject(splashActivity: SplashActivity)
}