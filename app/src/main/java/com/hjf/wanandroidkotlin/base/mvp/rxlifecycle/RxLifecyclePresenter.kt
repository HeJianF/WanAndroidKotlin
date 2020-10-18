package com.hjf.wanandroidkotlin.base.mvp.rxlifecycle

import com.trello.rxlifecycle3.LifecycleTransformer
import com.trello.rxlifecycle3.OutsideLifecycleException
import com.trello.rxlifecycle3.RxLifecycle
import io.reactivex.Observable
import io.reactivex.functions.Function

class RxLifecyclePresenter private constructor() {
    companion object {
        fun <T> bindPresenter(lifecycle: Observable<Int?>): LifecycleTransformer<T> {
            return RxLifecycle.bind(lifecycle, PRESENTER_LIFECYCLE)
        }

        private val PRESENTER_LIFECYCLE =
            Function<Int?, Int?> { lastEvent: Int ->
                when (lastEvent) {
                    PresenterEvent.ATTACH -> PresenterEvent.DETACH
                    PresenterEvent.DETACH -> throw OutsideLifecycleException("Cannot bind to Presenter lifecycle when outside of it.")
                    else -> throw UnsupportedOperationException("Binding to $lastEvent not yet implemented")
                }
            }
    }

    init {
        throw AssertionError("No instances")
    }
}