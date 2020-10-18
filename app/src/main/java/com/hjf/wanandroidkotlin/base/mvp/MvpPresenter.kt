package com.hjf.wanandroidkotlin.base.mvp

import androidx.annotation.CallSuper

/**
 * @author Jianfeng He
 * @email hjfstory@foxmail.com
 * 描述：继承此类，可以手动管理MVP的生命周期
 */
open class MvpPresenter<V : MvpView?> {

    private var mMvpView: V? = null

    @CallSuper
    open fun attachView(mvpView: V) {
        mMvpView = mvpView
    }

    @CallSuper
    open fun detachView() {
        mMvpView = null
    }

    fun isViewAttached(): Boolean {
        return mMvpView != null
    }

    fun getMvpView(): V? {
        return mMvpView
    }
}
