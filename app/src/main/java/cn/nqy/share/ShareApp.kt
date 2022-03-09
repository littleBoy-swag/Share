package cn.nqy.share

import android.app.Application
import cn.nqy.base.initialize.NqyShareStarter
import cn.nqy.share_qq.QQPlatformConfig

class ShareApp:Application() {

    override fun onCreate() {
        super.onCreate()
        NqyShareStarter
            .addPlatform(QQPlatformConfig("101997318"))
            .start(this)
    }

}