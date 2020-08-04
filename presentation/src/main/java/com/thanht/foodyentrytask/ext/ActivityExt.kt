package com.thanht.foodyentrytask.ext

import android.app.Activity
import com.thanht.foodyentrytask.MyApplication

fun Activity.applicationComponent() = MyApplication.applicationComponent(this)

fun Activity.userComponent() = MyApplication.userComponent(this)