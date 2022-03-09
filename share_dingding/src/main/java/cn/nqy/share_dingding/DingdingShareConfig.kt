package cn.nqy.share_dingding

import cn.nqy.base.IShareConfig
import cn.nqy.base.share_type.IShareType

class DingdingShareConfig private constructor() : IShareConfig {

    lateinit var shareType: IShareType

    companion object {
        fun newBuilder(): Builder {
            return Builder()
        }
    }

    class Builder {

        private val dingdingShareConfig = DingdingShareConfig()

        /**
         * 设置分享类型
         */
        fun setShareType(shareType: IShareType): Builder {
            dingdingShareConfig.shareType = shareType
            return this
        }

        fun create(): DingdingShareConfig = dingdingShareConfig

    }

}