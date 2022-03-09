package cn.nqy.share_qq

import android.app.Activity
import android.os.Bundle
import cn.nqy.base.IShare
import cn.nqy.base.IShareListener
import cn.nqy.base.Utils
import cn.nqy.base.share_type.ShareImageType
import cn.nqy.base.share_type.ShareRichTextType
import cn.nqy.share_qq.share_type.QQShareRichTextType
import com.tencent.connect.share.QQShare

class QShare(private val config: QQShareConfig) : IShare {
    override fun share(activity: Activity, shareListener: IShareListener) {
        // QQ or QQ极速版
        if (Utils.isTargetAppAvailable(activity, "com.tencent.qqlite")
            && Utils.isTargetAppAvailable(activity, "com.tencent.mobileqq")) {
            shareListener.onShareError(IllegalStateException("QQ未安装"))
            return
        }
        // 配置参数
        val params = Bundle()
        if (config.shareType is ShareImageType) { // 纯图片分享
            (config.shareType as? ShareImageType)?.let {
                params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_IMAGE)
                params.putString(QQShare.SHARE_TO_QQ_IMAGE_LOCAL_URL, it.picUrl)
            }
        }
        if (config.shareType is ShareRichTextType) { // 图文分享
            (config.shareType as? ShareRichTextType)?.let {
                params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT)
                params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, it.webUrl)
                params.putString(QQShare.SHARE_TO_QQ_TITLE, it.title)
                if (it is QQShareRichTextType && it.summary.isNotEmpty()) {
                    params.putString(QQShare.SHARE_TO_QQ_SUMMARY, it.summary)
                }
            }
        }
        // 开始分享
        shareListener.onShareStart()
        if (config.qPlatform == QQShareConfig.Q_PLATFORM_QQ) {
            shareToQQ(activity, params, shareListener)
        } else {
            shareToQZone(activity, params, shareListener)
        }
    }

    /**
     * 分享到QQ
     */
    private fun shareToQQ(activity: Activity, params: Bundle, listener: IShareListener) {
        QQController.get(activity).shareToQQ(activity, params, QQShareListenerImpl(listener))
    }

    /**
     * 分享到QQ空间
     */
    private fun shareToQZone(activity: Activity, params: Bundle, listener: IShareListener) {
        QQController.get(activity).shareToQzone(activity, params, QQShareListenerImpl(listener))
    }

    /**
     * 发布说说、视频、图片到QQ空间
     */
    private fun publishToZone(activity: Activity, params: Bundle, listener: IShareListener) {
        QQController.get(activity).publishToQzone(activity, params, QQShareListenerImpl(listener))
    }


}