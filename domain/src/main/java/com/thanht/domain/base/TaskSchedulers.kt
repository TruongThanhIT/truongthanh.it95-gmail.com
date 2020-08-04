package com.thanht.domain.base

import io.reactivex.Scheduler

interface TaskSchedulers {
    fun getIOThread(): Scheduler

    fun getMainThread(): Scheduler
}