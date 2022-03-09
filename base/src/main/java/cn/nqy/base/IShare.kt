package cn.nqy.base

import android.app.Activity

interface IShare {

    /**
     * 分享
     */
    fun share(activity: Activity, shareListener: IShareListener = DefaultShareListener())

}