package cn.nqy.base.initialize

import android.app.Application

interface IPlatformConfig {

    /**
     * 初始化
     */
    fun initialize(application: Application)
}