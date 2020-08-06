package com.thanht.domain.base

import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import io.reactivex.observers.DisposableObserver

abstract class BaseUseCase<T> {
    private var disposable = Disposables.empty()

    protected abstract fun buildObservable(): Observable<T>

    fun execute(
        useCaseSubscriber: DisposableObserver<T>,
        taskSchedulers: TaskSchedulers
    ): Disposable {
        disposable = completeObservable(taskSchedulers).subscribeWith(useCaseSubscriber)
        return disposable
    }

    fun unsubscribe() {
        if (disposable.isDisposed.not()) disposable.dispose()
    }

    private fun completeObservable(taskSchedulers: TaskSchedulers): Observable<T> = buildObservable()
        .subscribeOn(taskSchedulers.getIOThread())
        .observeOn(taskSchedulers.getMainThread())
}