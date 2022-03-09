package cn.nqy.share_qq

import android.content.Context
import com.tencent.tauth.Tencent

object QQController {

    /***
     * QQ分享操作
     */
    var controller: Tencent? = null

    /**
     * appId
     */
    var appId:String = ""

    fun get(context: Context):Tencent {
        return controller ?: Tencent.createInstance(appId, context.applicationContext)
    }

}