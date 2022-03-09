package cn.nqy.base


import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.net.URL
import java.util.*

class Utils {

    companion object {

        /**
         * 是否安装了目标App
         *
         * @param packageName 目标app的包名
         *
         */
        fun isTargetAppAvailable(context: Context, packageName: String): Boolean {
            return context.packageManager.getInstalledPackages(0)
                .any { it.packageName.lowercase(Locale.CHINA) == packageName }
        }

        /**
         * 下载网络图片
         *
         * @param picUrl 图片链接
         *
         */
        fun downloadImageByUrl(picUrl: String): File {
            try {
                val url = URL(picUrl)
                val inputStream = url.openStream()

            } catch (e: Exception) {

            }
            return File("")
        }


    }

}