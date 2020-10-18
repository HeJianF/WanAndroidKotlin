package com.hjf.wanandroidkotlin.base.mvp

import com.hjf.wanandroidkotlin.base.mvp.rxlifecycle.PresenterEvent
import com.hjf.wanandroidkotlin.base.mvp.rxlifecycle.RxLifecyclePresenter
import com.trello.rxlifecycle3.LifecycleProvider
import com.trello.rxlifecycle3.LifecycleTransformer
import com.trello.rxlifecycle3.RxLifecycle
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

/**
 * @author Jianfeng He
 * @email hjfstory@foxmail.com
 * 描述：继承此类，可以手动管理MVP的生命周期
 */
abstract class MvpLifecyclePresenter<V : MvpView?> : MvpPresenter<V>(), LifecycleProvider<Int> {

    private val behaviorSubject = BehaviorSubject.create<Int>()

    abstract fun start()

    override fun attachView(mvpView: V) {
        super.attachView(mvpView)
        behaviorSubject.onNext(PresenterEvent.ATTACH)
    }

    override fun detachView() {
        super.detachView()
        behaviorSubject.onNext(PresenterEvent.DETACH)
    }

    override fun lifecycle(): Observable<Int> {
        return behaviorSubject.cache()
    }

    override fun <T> bindToLifecycle(): LifecycleTransformer<T> {
        return RxLifecyclePresenter.bindPresenter(behaviorSubject)
    }

    override fun <T> bindUntilEvent(event: Int): LifecycleTransformer<T> {
        return RxLifecycle.bindUntilEvent(behaviorSubject, event)
    }
}