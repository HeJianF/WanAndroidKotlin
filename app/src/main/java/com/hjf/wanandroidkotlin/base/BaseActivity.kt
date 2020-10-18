package com.hjf.wanandroidkotlin.base

import com.hjf.wanandroidkotlin.base.mvp.MvpView
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity

/**
 * @author Jianfeng He
 * @email hjfstory@foxmail.com
 * 描述： 基类
 */
class BaseActivity : RxAppCompatActivity(), MvpView {
    override fun isAlive(): Boolean {
        TODO("Not yet implemented")
    }

}