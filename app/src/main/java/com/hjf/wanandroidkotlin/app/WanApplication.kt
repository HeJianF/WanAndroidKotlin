package com.hjf.wanandroidkotlin.app

import android.app.Application
import android.content.Context

/**
 * @author Jianfeng He
 * @email hjfstory@foxmail.com
 * 描述： 全局Application
 */
class WanApplication : Application() {

    companion object {
        var application: Context? = null
            private set
    }

    override fun onCreate() {
        super.onCreate()
        application = applicationContext
    }
}