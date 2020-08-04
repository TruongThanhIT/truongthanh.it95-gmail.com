package com.thanht.domain.base

import io.reactivex.Observable
import io.reactivex.disposables.Disposables

abstract class BaseUseCase<T> {
    private var disposable = Disposables.empty()

    protected abstract fun buildObservable(): Observable<T>

    fun completeObservable(taskSchedulers: TaskSchedulers) = buildObservable()
        .subscribeOn(taskSchedulers.getIOThread())

    fun unsubscribe() {
        if (disposable.isDisposed.not()) disposable.dispose()
    }
}