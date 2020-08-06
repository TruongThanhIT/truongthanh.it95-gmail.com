package com.thanht.foodyentrytask.ext

import android.app.Activity
import com.thanht.foodyentrytask.MyApplication

fun Activity.userComponent() = (applicationContext as MyApplication).userComponent