package com.hjf.wanandroidkotlin.base.mvp

/**
 * @author Jianfeng He
 * @email hjfstory@foxmail.com
 * 描述： 生命周期管理
 */
interface MvpView {
    /**
     * View的宿主已经被销毁了么
     */
    fun isAlive(): Boolean
}