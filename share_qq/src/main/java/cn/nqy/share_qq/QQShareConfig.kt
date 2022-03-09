package cn.nqy.share_qq

import cn.nqy.base.IShareConfig
import cn.nqy.base.share_type.IShareType

class QQShareConfig private constructor() : IShareConfig {

    lateinit var shareType: IShareType

    var qPlatform = Q_PLATFORM_QQ

    companion object {

        /**
         * QQ
         */
        const val Q_PLATFORM_QQ = 1

        /**
         * QQ空间
         */
        const val Q_PLATFORM_QZONE = 2

        fun newBuilder(): Builder {
            return Builder()
        }
    }

    class Builder {

        private val qqShareConfig: QQShareConfig = QQShareConfig()

        fun setQPlatform(qPlatform: Int): Builder {
            if (qPlatform == Q_PLATFORM_QQ || qPlatform == Q_PLATFORM_QZONE) {
                qqShareConfig.qPlatform = qPlatform
            }
            return this
        }

        fun setShareType(shareType: IShareType): Builder {
            qqShareConfig.shareType = shareType
            return this
        }

        fun create(): QQShareConfig {
            return qqShareConfig
        }

    }

}