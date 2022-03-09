package cn.nqy.share_qq

import cn.nqy.base.IShareListener
import com.tencent.tauth.IUiListener
import com.tencent.tauth.UiError

/**
 * QQ分享默认回调
 */
class QQShareListenerImpl(private val listener: IShareListener) : IUiListener {
    override fun onComplete(p0: Any?) {
        listener.onShareSuccess()
    }

    override fun onError(p0: UiError?) {
        if (p0 == null) {
            listener.onShareError(IllegalStateException("QQ分享出错"))
            return
        }
        listener.onShareError(IllegalStateException(p0.errorMessage))
    }

    override fun onCancel() {
        listener.onShareCancel()
    }

    override fun onWarning(p0: Int) {
        listener.onShareError(IllegalStateException("QQ分享onWarning"))
    }
}