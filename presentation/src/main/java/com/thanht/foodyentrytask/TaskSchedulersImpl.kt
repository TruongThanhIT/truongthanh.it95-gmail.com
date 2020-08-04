package com.thanht.foodyentrytask

import com.thanht.domain.base.TaskSchedulers
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TaskSchedulersImpl @Inject constructor() : TaskSchedulers {
    override fun getIOThread(): Scheduler = Schedulers.io()

    override fun getMainThread(): Scheduler = AndroidSchedulers.mainThread()
}