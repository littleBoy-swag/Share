package cn.nqy.base.initialize

import android.app.Application

object NqyShareStarter {

    private val platformList = ArrayList<IPlatformConfig>()

    /**
     * 添加平台
     */
    fun addPlatform(platformConfig: IPlatformConfig): NqyShareStarter {
        platformList.add(platformConfig)
        return this
    }

    /**
     * 执行初始化操作
     */
    fun start(application: Application) {
        platformList.forEach {
            it.initialize(application)
        }
    }

}