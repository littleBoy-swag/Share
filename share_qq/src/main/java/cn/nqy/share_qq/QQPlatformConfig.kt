package cn.nqy.share_qq

import android.app.Application
import android.os.Build
import cn.nqy.base.initialize.IPlatformConfig
import com.tencent.tauth.Tencent

/**
 * QQ平台初始化配置
 */
class QQPlatformConfig(private val appId: String) : IPlatformConfig {
    override fun initialize(application: Application) {
        // 在调用互联SDK相关功能接口之前，需要应用在确认用户已授权应用获取设备信息
        Tencent.setIsPermissionGranted(true, Build.MODEL)
        QQController.appId = appId
        QQController.controller = Tencent.createInstance(appId, application.applicationContext)
    }
}